package Fachlogik;

public class Armband extends Artikel {
    private int laenge;
    private  int breite;

    public Armband( double preis, String bezeichnung,ArtikelZustand zustand, String hersteller, int laenge, int breite) {
        super( preis, bezeichnung,zustand, hersteller);
        this.laenge = laenge;
        this.breite = breite;

    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    @Override
    public String toString() {
        return super.toString()+"Fachlogik.Armband{" +
                "laenge=" + laenge +
                ", breite=" + breite +
                '}';
    }
}
