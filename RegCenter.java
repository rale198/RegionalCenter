package RegionalniCentar;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import static org.apache.http.client.methods.RequestBuilder.post;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RegCenter {
 
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    public boolean checkIsAvail()
    {
        StringBuilder url = new StringBuilder(
                "http://collabnet.netset.rs:8081/is/terminCentar/checkTimeslotAvailability?regionalniCentarId=");
        url.append("17398&").append("termin=").append(RegCenter.getCurrentTime());
        
        HttpGet getRequest = new HttpGet(url.toString());
        getRequest.setHeader("Content-type", "application/json");
        
        ObjectMapper om = new ObjectMapper();
        
        try (CloseableHttpResponse response = httpClient.execute(getRequest)) {
            int status = response.getStatusLine().getStatusCode();
            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String jsonRet = EntityUtils.toString(entity);
                TerminAvailableMessage tam;
                tam = om.readValue(jsonRet, TerminAvailableMessage.class);
                
                return tam.getDostupnost();
                
            } else if (status == 400) {
                
                System.out.println("NEVALIDAN PARAMAETAR");
                System.out.println(EntityUtils.toString(response.getEntity()));
                return false;
            }
        } catch (IOException ex) {System.out.println("exception");}
        
        return false;
    }
    
    public String createRequest(Request req)
    {
        
        EntityManager em = Database.getInstance().getEntityManager();
        
        Documentrequest dr = new Documentrequest();
        dr.setStatus("kreiran");
        em.getTransaction().begin();
        em.persist(dr);
        em.getTransaction().commit();
        
        int id = dr.getId();
        String zahtevId = "17398" + String.format("%07d", id);
        req.setId(zahtevId);
        
        ObjectMapper om = new ObjectMapper();
        String json = "";
        try {
            json = om.writeValueAsString(req);
        } catch (JsonProcessingException ex) {
        }
        json = json.replaceFirst("jmbg", "JMBG");
        HttpPost post = new HttpPost("http://collabnet.netset.rs:8081/is/persoCentar/submit");    
        post.setHeader("Content-type", "application/json");
        StringEntity se = null;
        try {
            se = new StringEntity(json);
        } catch (UnsupportedEncodingException ex) {
        }
        post.setEntity(se);
        String retVal=null;
        try (CloseableHttpResponse response = httpClient.execute(post)) {
            int status = response.getStatusLine().getStatusCode();
            if (status == 201 || status == 200) {
                HttpEntity entity = response.getEntity();
                String jsonRet = EntityUtils.toString(entity);
                DocumentSubmitResponse dsr = om.readValue(jsonRet,DocumentSubmitResponse.class);                
                dr.setStatus("uProdukciji");
                em.getTransaction().begin();
                em.persist(dr);
                em.getTransaction().commit();
                retVal= dsr.getId();
                
            } else if (status == 400) {               
                System.out.println(EntityUtils.toString(response.getEntity()));
                retVal= "400";
            }
        } catch (IOException ex) {}
        
        return retVal;
    }
    
    public void setStatus(String status,String id)
    {
        EntityManager em = Database.getInstance().getEntityManager();
        int idDoc=Integer.parseInt(id.substring(5));
        Documentrequest dr = em.find(Documentrequest.class, idDoc);
        if(dr==null)
            return;
        
        dr.setStatus(status);
        
        em.getTransaction().begin();
        em.persist(dr);
        em.getTransaction().commit();
        
    }
    private static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        //Vreme koje uvek vrati dostupnost=true
        try {
            date = sdf.parse("2020-02-03T10:45:00");
        }
        catch (ParseException ex) {}
        
        return sdf.format(date);
    }
    
    public String checkIDStatus(String id)
    {
        EntityManager em = Database.getInstance().getEntityManager();
        int idDoc=Integer.parseInt(id.substring(5));
        Documentrequest dr = em.find(Documentrequest.class, idDoc);
        if(dr.getStatus().equals("uProdukciji")==false)
            return dr.getStatus();
        
        String url="http://collabnet.netset.rs:8081/is/persoCentar/"+id;
        
        HttpGet getRequest = new HttpGet(url);
        getRequest.setHeader("Content-type", "application/json");
        
        ObjectMapper om = new ObjectMapper();
        
        try (CloseableHttpResponse response = httpClient.execute(getRequest)) {
            int status = response.getStatusLine().getStatusCode();
            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String jsonRet = EntityUtils.toString(entity);
                jsonRet = jsonRet.replaceFirst("JMBG", "jmbg");
                DocumentResponse tam;
                tam = om.readValue(jsonRet, DocumentResponse.class);
                setStatus(tam.getStatus(), tam.getId());
                return tam.getStatus();
                
            } else if (status == 400) {
                
                System.out.println(EntityUtils.toString(response.getEntity()));
                return "LOS ID FORMAT";
            }
            else if(status == 404)
            {
                System.out.println(EntityUtils.toString(response.getEntity()));
                return "ZAHTEV NIJE UPUCEN";
            }
        } catch (IOException ex) {System.out.println("exception");}
        
        return "";
    }            
}
