package Fachlogik;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Observable;

public class Bestellung extends Observable implements Serializable {
    private static int bestellID = 1;
    private int fixeBestellID;
    private ArtikelListe artikelListe;
    private  BestellungStatus bestellStatus;
    private double betrag ;
    private String bestell_datum;
    private Zahlungsmethode zahlungsmethode;

    public Bestellung(Zahlungsmethode zahlungsmethode, ArtikelListe artikelListe) {
        this.artikelListe = artikelListe;
        this.zahlungsmethode = zahlungsmethode;
//        this.zahlungsmethode.setZuzahlenBetrag(this.getBetrag());
        this.betrag = this.getBetrag();
        LocalDateTime date = LocalDateTime.now();
        this.bestell_datum = date.toString();
        this.fixeBestellID = bestellID;
        this.bestellStatus = BestellungStatus.BEARBEITET;
        bestellID++;
    }

    public BestellungStatus getBestellStatus() {
        return bestellStatus;
    }

    public void setBestellStatus() {
        this.bestellStatus = this.bestellStatus.changeState();
        setChanged();
        notifyObservers();
    }

    public static int getBestellID() {
        return bestellID;
    }

    public int getFixeBestellID() {
        return fixeBestellID;
    }

    public ArtikelListe getArtikelListe() {
        return artikelListe;
    }

    public void setArtikelListe(ArtikelListe artikelListe) {
        this.artikelListe = artikelListe;
    }

    public double getBetrag() {
        betrag = this.artikelListe.betragBerechnen();
        return betrag;
    }

    public String getBestell_datum() {
        return bestell_datum;
    }

    public void setBestell_datum(String bestell_datum) {
        this.bestell_datum = bestell_datum;
    }

    public Zahlungsmethode getZahlungsmethode() {
        return zahlungsmethode;
    }

    public void setZahlungsmethode(Zahlungsmethode zahlungsmethode) {
        this.zahlungsmethode = zahlungsmethode;
    }

    public void addArtikelListe(ArtikelListe artikelListe){
        artikelListe = new ArtikelListe();
    }
    public void removeArtikelListe(ArtikelListe artikelListe){
        if(artikelListe != null)
            artikelListe = null;
    }

    public void bezahlen(){
        this.setBestellStatus();
        System.out.println("Bezahlt "+ this.betrag +" mit "+this.zahlungsmethode.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "fixeBestellID=" + fixeBestellID +
                ", artikelListe=" + artikelListe +
                ", bestellStatus=" + bestellStatus +
                ", betrag=" + betrag +
                ", bestell_datum='" + bestell_datum + '\'' +
                ", zahlungsmethode=" + zahlungsmethode.getClass().getSimpleName() +
                '}'+"\n";

    }
}
