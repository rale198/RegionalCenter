package RegionalniCentar;

import com.fasterxml.jackson.annotation.JsonSetter;

public class TerminAvailableMessage {
    
    
    private boolean dostupnost;
    private String poruka;

    public String getPoruka() {
        return poruka;
    }

    public boolean getDostupnost() {
        return dostupnost;
    }

    @JsonSetter("poruka")
    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    @JsonSetter("dostupnost")
    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }    
}
