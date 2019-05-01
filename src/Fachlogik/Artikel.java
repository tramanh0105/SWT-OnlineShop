package Fachlogik;


import java.util.Observable;

public abstract class Artikel extends Observable implements Comparable<Artikel> {

    private static long artikelID = 0;
    private double preis;
    private String bezeichnung;
    private ArtikelZustand zustand;
    private String hersteller;
    private long fixeArtikelId;
    private int anfangBestand = 0;


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

    public int getAnfangBestand() {
        return anfangBestand;
    }

    public void setAnfangBestand(int anfangBestand) {
        this.anfangBestand = anfangBestand;
    }

    public ArtikelZustand getZustand() {
        return zustand;
    }

    public void setZustand(ArtikelZustand zustand) {
        //if the current state of the article is "out of stock" gets changed to "available", we'll inform the
        if(this.getZustand().toString().equals("AUSVERKAUFT") &&  this.zustand != zustand) {
            this.zustand = zustand;
            setChanged();
            notifyObservers();
        }
    }

    public static long getArtikelID() {
        return artikelID;
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

    public String getBezeichnung() {
        return bezeichnung;
    }


    public String getHersteller() {
        return hersteller;
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
    //user can subscribe to an article in case the article out of stock

    public void subscribe(Account account){
        this.addObserver(account);
    }
}
