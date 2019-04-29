package Fachlogik;

import Fachlogik.Artikel;
import Fachlogik.ArtikelZustand;

public class Damenuhr extends Artikel {
    private int durchmesser;

    public Damenuhr(double preis, String bezeichnung, ArtikelZustand zustand, String hersteller, int durchmesser) {
        super(preis, bezeichnung,zustand, hersteller);
        this.durchmesser = durchmesser;
    }

    public int getDurchmesser() {
        return durchmesser;
    }

    public void setDurchmesser(int durchmesser) {
        this.durchmesser = durchmesser;
    }

    @Override
    public String toString() {

        return super.toString() + "Fachlogik.Damenuhr {" +
                "durchmesser" +
                "=" + durchmesser +
                '}';
    }

}
