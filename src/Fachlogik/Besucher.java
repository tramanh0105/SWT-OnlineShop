package Fachlogik;

public class Besucher {
    private String benutzername;
    private String passwort;
    private Warenkorb warenkorb;

    public String getBenutzername() {
        return benutzername;
    }

    public Warenkorb getWarenkorb() {
        return warenkorb;
    }

    public void setWarenkorb(Warenkorb warenkorb) {
        this.warenkorb = warenkorb;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public void registrieren(String benutzername, String passwort){
        System.out.println("Du hast erforgreich registriert");
    }
}
