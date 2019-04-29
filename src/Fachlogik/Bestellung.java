package Fachlogik;

import java.time.LocalDateTime;

public class Bestellung {
    private static int bestellID = 1;
    private int fixeBestellID;
    private ArtikelListe artikelListe;
    private enum BestellStatus {
        BEABERTET, BEZAHLT, GELIEFERT, ZUGESTELLT;
    }

    private double betrag ;
    private String bestell_datum;
    private Zahlungsmethode zahlungsmethode;

    public Bestellung(Zahlungsmethode zahlungsmethode, ArtikelListe artikelListe) {
        this.artikelListe = artikelListe;
        this.zahlungsmethode = zahlungsmethode;
        LocalDateTime date = LocalDateTime.now();
        this.bestell_datum = date.toString();
        this.fixeBestellID = bestellID;
        bestellID++;
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
}
