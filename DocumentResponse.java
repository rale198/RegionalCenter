package RegionalniCentar;

import com.fasterxml.jackson.annotation.JsonSetter;

public class DocumentResponse {
    private String jmbg;
    private String bracnoStanje;
    private String brojPrebivalista;
    private String datumRodjenja;
    private String id;
    private String ime;
    private String imeMajke;
    private String imeOca;
    private String nacionalnost;
    private String opstinaPrebivalista;
    private String pol;
    private String prezime;
    private String prezimeMajke;
    private String prezimeOca;
    private String profesija;
    private String status;
    private String ulicaPrebivalista;
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    } 
    

    public String getPrezimeMajke() {
        return prezimeMajke;
    }

    public String getPrezimeOca() {
        return prezimeOca;
    }

    public String getImeMajke() {
        return imeMajke;
    }

    public String getImeOca() {
        return imeOca;
    }

    public String getPol() {
        return pol;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getProfesija() {
        return profesija;
    }

    public String getNacionalnost() {
        return nacionalnost;
    }

    public String getOpstinaPrebivalista() {
        return opstinaPrebivalista;
    }

    public String getUlicaPrebivalista() {
        return ulicaPrebivalista;
    }

    public String getBrojPrebivalista() {
        return brojPrebivalista;
    }

    public String getBracnoStanje() {
        return bracnoStanje;
    }
    
    
    
    public void setId(String id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @JsonSetter("jmbg")
    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }


    public void setPrezimeMajke(String prezimeMajke) {
        this.prezimeMajke = prezimeMajke;
    }

    public void setPrezimeOca(String prezimeOca) {
        this.prezimeOca = prezimeOca;
    }

    public void setImeMajke(String imeMajke) {
        this.imeMajke = imeMajke;
    }

    public void setImeOca(String imeOca) {
        this.imeOca = imeOca;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public void setProfesija(String profesija) {
        this.profesija = profesija;
    }

    public void setNacionalnost(String nacionalnost) {
        this.nacionalnost = nacionalnost;
    }

    public void setOpstinaPrebivalista(String opstinaPrebivalista) {
        this.opstinaPrebivalista = opstinaPrebivalista;
    }

    public void setUlicaPrebivalista(String ulicaPrebivalista) {
        this.ulicaPrebivalista = ulicaPrebivalista;
    }

    public void setBrojPrebivalista(String brojPrebivalista) {
        this.brojPrebivalista = brojPrebivalista;
    }

    public void setBracnoStanje(String bracnoStanje) {
        this.bracnoStanje = bracnoStanje;
    }
}
