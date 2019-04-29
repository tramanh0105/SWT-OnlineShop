package Fachlogik;

public class Überweisung extends Zahlungsmethode {
    private String kontoinhaber;
    private String bankleizahl;

    public Überweisung(String kartennummer, String kontoinhaber, String bankleizahl) {
        super(kartennummer);
        this.kontoinhaber = kontoinhaber;
        this.bankleizahl = bankleizahl;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public String getBankleizahl() {
        return bankleizahl;
    }

    public void setBankleizahl(String bankleizahl) {
        this.bankleizahl = bankleizahl;
    }

    @Override
    public void bezahlen(double betrag) {
        System.out.println("bezahlt mit Banküberweisung");
    }
}
