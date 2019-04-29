package Fachlogik;

public class Rechnung {
    private static int rechnungsnummer = 1;
    private final double mehrwertsteuer = 0.19;
    private Account account;
    private Bestellung bestellung;
    private double gesamtbetrag ;
    private double nettobetrag ;
    private int fixeRechnungsnummer;
    private Adresse lieferadresse ;

    public Rechnung() {
        fixeRechnungsnummer = rechnungsnummer;
        rechnungsnummer++;
    }

    public static int getRechnungsnummer() {
        return rechnungsnummer;
    }

    public double getGesamtbetrag() {
        gesamtbetrag = this.bestellung.getBetrag();
        return gesamtbetrag;
    }

    public double getMehrwertsteuer() {
        return mehrwertsteuer;
    }

    public double getNettobetrag() {
        nettobetrag = this.getGesamtbetrag()*(1-mehrwertsteuer);
        return nettobetrag;
    }

    public void setLieferadresse(Adresse lieferadresse) {
        this.lieferadresse = lieferadresse;
    }

    public Adresse getLieferadresse() {
        return this.account.getAdress();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Bestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(Bestellung bestellung) {
        this.bestellung = bestellung;
    }


    public void rechnungDrucke() {
        String rechnungsatz= "Rechnung{"
                +"\n bestellung=" + bestellung.getArtikelListe().druckeArtikelListe() +
                "\n mehrwertsteuer=" + mehrwertsteuer +
                "\n nettobetrag=" + this.getNettobetrag() +
                "\n gesamtbetrag=" + this.getGesamtbetrag() +
                "\n account=" + account.toString() +
                "\n Bestellsdatum = " + bestellung.getBestell_datum()+
                "\nRechnungsnummer=" + fixeRechnungsnummer +
                "\nlieferadresse=" + this.getLieferadresse().toString() +
                '}';
        System.out.println(rechnungsatz);
    }
}

