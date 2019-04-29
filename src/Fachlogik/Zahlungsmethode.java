package Fachlogik;

public abstract class Zahlungsmethode {
    private String kartennummer;

    public Zahlungsmethode(String kartennummer) {
        this.kartennummer = kartennummer;
    }

    public String getKartennummer() {
        return kartennummer;
    }

    public void setKartennummer(String kartennummer) {
        this.kartennummer = kartennummer;
    }

    public abstract void bezahlen(double betrag);
}
