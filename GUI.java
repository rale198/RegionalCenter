package projekat17pts;

import RegionalniCentar.RegCenter;
import RegionalniCentar.Request;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTabbedPane;

public class GUI extends Frame{

    private MenuBar menu = new MenuBar();
    private Menu options=new Menu("opcije"); //podaci za meni
    private MenuItem dataCollection = new MenuItem("Unos podataka");
    private MenuItem statusCheck = new MenuItem("Provera statusa"); //obrisati
    
    private RegCenter myService;
    private Panel dataPanel = null;
    private Panel statuscheckPanel = null;
    
    private void addButtonListeners()
    {     
        guiButton.addActionListener((e)->{
            loadDataAction();
        });
    }
    public GUI() {
        super("Prozor");
        setBounds(250, 250, 800, 500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {dispose();}
        });
        
        myService = new RegCenter();
        addButtonListeners();
        showDataFrame();
        showStatusFrame();
        pane.insertTab("Unos podataka",null,dataPanel,"u",0);
        pane.insertTab("Provera zahteva",null,statuscheckPanel,"p",1);
        this.add(pane);
        setVisible(true);
    }
    
    
    private TextField jmbg = new TextField();
    private TextField surename = new TextField();
    private TextField name = new TextField();
    
    private TextField mumsn = new TextField();
    private TextField mumn = new TextField();
    
    private TextField dadsn = new TextField();
    private TextField dadn = new TextField();
    
    private Button guiButton = new Button("Kreiraj zahtev");
    
    private TextField nationallity=new TextField();
    private TextField proffesion = new TextField();
    private TextField area = new TextField();
    private TextField street = new TextField();
    private TextField number = new TextField();
    
    private Panel genderPanel = new Panel(new GridLayout(1,3));
    private CheckboxGroup grupa = new CheckboxGroup();
    private Checkbox male = new Checkbox("muski", grupa, false);
    private Checkbox female = new Checkbox("zenski", grupa, false);
    
    private Panel statePanel =new Panel(new GridLayout(2,2));
    private CheckboxGroup grupa2 = new CheckboxGroup();
    
    private Checkbox married = new Checkbox("ozenjen/udata", grupa2, false);
    private Checkbox divorced = new Checkbox("razveden/a", grupa2, false);    
    private Checkbox free = new Checkbox("neozeljen/a", grupa2, false);
    private Checkbox widow = new Checkbox("udovac/udovica",grupa2,false);
    
    private void addStatePanel()
    {
        statePanel.add(new Label("Bracni status:"));
        statePanel.add(married);
        statePanel.add(divorced);
        statePanel.add(free);
        
        this.dataPanel.add(statePanel);
    }
    private void addGenderPanel()
    {
        genderPanel.add(new Label("Pol:"));
        genderPanel.add(male);
        genderPanel.add(female);
        
        this.dataPanel.add(genderPanel);
    }
    private Panel birthPanel = new Panel(new GridLayout(2,3));
    private TextField day=new TextField(),month=new TextField(),year=new TextField();
    
    private void addBirthPanel()
    {
        Label l = new Label("Datum rodjenja:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        birthPanel.add(new Label("Dan:"));
        birthPanel.add(new Label("Mesec:"));
        birthPanel.add(new Label("Godina:"));
        
        birthPanel.add(day);
        birthPanel.add(month);
        birthPanel.add(year);
        this.dataPanel.add(birthPanel);
    }
    private void addGenderState()
    {
        addGenderPanel();
        addStatePanel();
    }
    JTabbedPane pane = new JTabbedPane();
    private void showDataFrame()
    {
        dataPanel = new Panel();
        this.dataPanel.setLayout(new GridLayout(8,4));
        
        Label l = new Label("JMBG:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        
        Panel wrapJmbg = new Panel(new GridLayout(3, 1));
        wrapJmbg.add(new Label(""));
        wrapJmbg.add(jmbg);
        dataPanel.add(wrapJmbg);
        
        l = new Label("Prezime:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        
        Panel wrapSurename = new Panel(new GridLayout(3, 1));
        wrapSurename.add(new Label(""));
        wrapSurename.add(surename);
        dataPanel.add(wrapSurename);
        
        l = new Label("Ime:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        
        Panel wrapName = new Panel(new GridLayout(3, 1));
        wrapName.add(new Label(""));
        wrapName.add(name);
        dataPanel.add(wrapName);
        
        addBirthPanel();
        
        l = new Label("Ime majke:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        
        Panel wrapMumn = new Panel(new GridLayout(3, 1));
        wrapMumn.add(new Label(""));
        wrapMumn.add(mumn);
        dataPanel.add(wrapMumn);        
        
        l = new Label("Prezime majke:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        Panel wrapMumsn = new Panel(new GridLayout(3, 1));
        wrapMumsn.add(new Label(""));
        wrapMumsn.add(mumsn);
        dataPanel.add(wrapMumsn);
        
        l = new Label("Ime oca:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        Panel wrapDadn = new Panel(new GridLayout(3, 1));
        wrapDadn.add(new Label(""));
        wrapDadn.add(dadn);
        dataPanel.add(wrapDadn);  
        
        
        l = new Label("Prezime oca:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        Panel wrapDadsn = new Panel(new GridLayout(3, 1));
        wrapDadsn.add(new Label(""));
        wrapDadsn.add(dadsn);
        dataPanel.add(wrapDadsn);
                       
        l = new Label("Nacionalnost:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        Panel wrapNat = new Panel(new GridLayout(3, 1));
        wrapNat.add(new Label(""));
        wrapNat.add(nationallity);
        dataPanel.add(wrapNat);
        
        l = new Label("Profesija:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        Panel wrapProf = new Panel(new GridLayout(3, 1));
        wrapProf.add(new Label(""));
        wrapProf.add(proffesion);
        dataPanel.add(wrapProf);
                 
        l = new Label("Opstina:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        Panel wrapArea = new Panel(new GridLayout(3, 1));
        wrapArea.add(new Label(""));
        wrapArea.add(area);
        dataPanel.add(wrapArea);   
        
        l = new Label("Ulica:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        Panel wrapStr = new Panel(new GridLayout(3, 1));
        wrapStr.add(new Label(""));
        wrapStr.add(street);
        dataPanel.add(wrapStr);   
        
        
        l = new Label("Broj:");
        l.setAlignment(Label.CENTER);
        dataPanel.add(l);
        Panel wrapNum = new Panel(new GridLayout(3, 1));
        wrapNum.add(new Label(""));
        wrapNum.add(number);
        dataPanel.add(wrapNum);  
        
        addGenderState();
        responseLabel.setAlignment(Label.CENTER);
        responseLabel.setForeground(Color.BLACK);
        responseLabel.setFont(new Font("Calibri",Font.ITALIC,20));
        dataPanel.add(guiButton);
        showIDLabel.setFont(new Font("Calibri",Font.ITALIC+Font.BOLD,20));
        showIDLabel.setAlignment(Label.CENTER);
        dataPanel.add(showIDLabel);
        dataPanel.add(responseLabel);
        Panel p = new Panel(new GridLayout(2,2));
        p.add(widow);
        p.add(new Label("a"));
        p.add(new Label(""));
        p.add(new Label(""));
        dataPanel.add(p);
    };
    
    private Label showIDLabel = new Label("");
    private Label responseLabel = new Label("");
    
    private String dobString(){
        return year.getText()+"-"+month.getText()+"-"+day.getText();
    }
    private String addGenderString()
    {
        if(female.getState())        
            return "zenski";
        
        if(male.getState())
            return "muski";
        return "";
    }
    private String addStateString()
    {
        if(widow.getState())        
            return "udovac/udovica";            
        
        if(divorced.getState())       
            return "razveden/a";
        
        if(married.getState())
            return "ozenjen/udata";
        
        if(free.getState())       
            return "neozeljen/a";
        
        return "";
    }
   private Request pickUpData()
   {
       String str;
       Request ret = new Request();
       ret.setJMBG(jmbg.getText());
       str=addStateString();
       if(str.equals(""))
           return null;
       ret.setBracnoStanje(str);
       ret.setBrojPrebivalista(number.getText());
       ret.setDatumRodjenja(dobString());
       ret.setId("");
       ret.setIme(name.getText());
       ret.setImeMajke(mumn.getText());
       ret.setImeOca(dadn.getText());
       ret.setPrezime(surename.getText());
       ret.setPrezimeOca(dadsn.getText());
       ret.setPrezimeMajke(mumsn.getText());
       ret.setProfesija(proffesion.getText());
       ret.setNacionalnost(nationallity.getText());
       ret.setOpstinaPrebivalista(area.getText());
       str = addGenderString();
       if(str.equals(""))
           return null;
       ret.setPol(str);
       ret.setUlicaPrebivalista(street.getText());
       
       return ret;
   }
    private void loadDataAction(){
        
        if(myService.checkIsAvail()==false)
        {
            responseLabel.setText("Termin nedostupan!");
            showIDLabel.setText("");
            return;
        }
        
        Request req = pickUpData();
        
        if(req==null)
        {
            responseLabel.setText("Unos nevalidan!");
            showIDLabel.setText("");
            return;
        }
        
        String str = myService.createRequest(req);
        
        if(str.equals("400"))
        {
            responseLabel.setText("Pao server!");
            showIDLabel.setText("");
            return;
        }
        responseLabel.setText("Zahtev kreiran!");
        showIDLabel.setText("ID:"+str);
    };
    private TextField idEntryCheck = new TextField();
    private Label statusLabel = new Label();
    
    private Button statusOptions = new Button("Proveri");
    private Button refresh = new Button("Osvezi");
    private Button giveIt = new Button("Uruci");
    
    private String refreshCheckerId=null;
    private void loadIDCheck()
    {
        giveIt.setVisible(false);
        refresh.setVisible(false);
        if(idEntryCheck.getText().equals(""))
            return;
        refreshCheckerId=idEntryCheck.getText();
        String str = myService.checkIDStatus(refreshCheckerId);
        if(str.equals("uProdukciji"))
        {
            //statusLabel.setText("u Produkciji");
            refresh.setVisible(true);
        }
        else if(str.equals("proizveden"))
        {
            //statusLabel.setText(str);
            giveIt.setVisible(true);
        }
        statusLabel.setText(str);
    }
    
    private void loadRefreshCheck()
    {
        String str = myService.checkIDStatus(refreshCheckerId);
        if(str.equals("proizveden"))
        {
            statusLabel.setText(str);
            giveIt.setVisible(true);
            refresh.setVisible(false);
        }
    }
    
    private void loadGiveAction()
    {
        myService.setStatus("Urucen", refreshCheckerId);
        statusLabel.setText("Urucen");
        giveIt.setVisible(false);
    }
    private void showStatusFrame()
    {
        statuscheckPanel = new Panel(new GridLayout(3,3));
        Label l = new Label("ID:");
        l.setAlignment(Label.CENTER);
        l.setForeground(Color.BLUE);
        l.setFont(new Font("Calibri",Font.BOLD,24) {
        });
        
        statusOptions.addActionListener((e)->{
            
           loadIDCheck();
            
        });
        
        refresh.addActionListener((e)->{
            
            loadRefreshCheck();
            
        });
        
        giveIt.addActionListener((e)->{
            loadGiveAction();
        });
        
        statuscheckPanel.add(l);
        Panel idEntryCheckPanel=new Panel(new GridLayout(3,1));
        idEntryCheckPanel.add(new Label(""));
        idEntryCheck.setFont(new Font("Calibri",Font.CENTER_BASELINE,24) {
        }); 
        idEntryCheckPanel.add(idEntryCheck);
        idEntryCheckPanel.add(new Label(""));
        
        statuscheckPanel.add(idEntryCheckPanel);
        statuscheckPanel.add(new Label(""));
        statuscheckPanel.add(new Label(""));
        
        refresh.setForeground(Color.GREEN);
        refresh.setFont(new Font("Calibri",16,Font.PLAIN) {
        });
        refresh.setVisible(false);
        giveIt.setVisible(false);
        
        Panel statusOptionsPanel= new Panel(new GridLayout(3,1));
        statusOptionsPanel.add(statusOptions);
        statusOptionsPanel.add(refresh);
        statusOptionsPanel.add(giveIt);
        statuscheckPanel.add(statusOptionsPanel);
        
        statuscheckPanel.add(new Label(""));
        
        l=new Label("Status:");
        l.setAlignment(Label.CENTER);
        l.setForeground(Color.BLUE);
        l.setFont(new Font("Calibri",Font.BOLD,24) {
        });
        
        statuscheckPanel.add(l);
        
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setFont(new Font("Fixedsys",Font.CENTER_BASELINE,24));
        statusLabel.setForeground(Color.GREEN);
        statuscheckPanel.add(statusLabel);
        statuscheckPanel.add(new Label(""));
    }
}
