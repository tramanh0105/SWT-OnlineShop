package Fachlogik;

public abstract class Artikel implements Comparable<Artikel> {
    private static long artikelID = 0;
    private double preis;
    private String bezeichnung;
    private ArtikelZustand zustand;
    private String hersteller;
    private long fixeArtikelId;

//    public Fachlogik.Artikel( double preis, String bezeichnung, String hersteller) {
//        this.preis = preis;
//        this.bezeichnung = bezeichnung;
//        this.hersteller = hersteller;
//        fixeArtikelId = artikelID;
//        artikelID ++;
//    }

    public Artikel(double preis, String bezeichnung, ArtikelZustand zustand, String hersteller) {
        this.preis = preis;
        this.bezeichnung = bezeichnung;
        this.zustand = zustand;
        this.hersteller = hersteller;
        fixeArtikelId = artikelID;
        artikelID ++;
    }

    public ArtikelZustand getZustand() {
        return zustand;
    }

    public void setZustand(ArtikelZustand zustand) {
        this.zustand = zustand;
    }

    public static long getArtikelID() {
        return artikelID;
    }

    public static void setArtikelID(long artikelID) {
        Artikel.artikelID = artikelID;
    }

    public long getFixeArtikelId() {
        return fixeArtikelId;
    }

    public void setFixeArtikelId(long fixeArtikelId) {
        this.fixeArtikelId = fixeArtikelId;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    @Override
    public String toString() {
        return "Fachlogik.Artikel{" +
                "artikelID=" + fixeArtikelId +
                ", preis=" + preis +
                ", bezeichnung='" + bezeichnung + '\'' +
                ", hersteller='" + hersteller + '\'' +
                '}';
    }
    @Override
    public int compareTo(Artikel o) {
        if(this.getPreis()>o.getPreis())
            return 1;
        else
            return -1;
    }
}
