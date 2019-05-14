package Fachlogik;

import java.io.Serializable;

public class Adresse implements Serializable {
    private int plz;
    private String strasse;
    private int hausnummer;
    private String stadt;
    public Adresse( String strasse, int hausnummer,int plz, String stadt) {
        this.plz = plz;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.stadt = stadt;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                ", strasse='" + strasse + '\'' +
                ", hausnummer=" + hausnummer +
                 ", plz=" + plz +
                ", stadt='" + stadt + '\'' +
                '}';
    }
}
