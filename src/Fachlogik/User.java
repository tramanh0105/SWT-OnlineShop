package Fachlogik;

public class User {
    private Account acc;
    private static long usernr;
    private String name;
    private String benutzername;
    private String passwort;
    private String email;
    private String telefonnumer;
    private String geburstdatum;
    private long fixeUserNr;

    public User(String benutzername, String passwort) {
        this.benutzername = benutzername;
        this.passwort = passwort;
        fixeUserNr = usernr;
        usernr++;
    }

    public static long getUsernr() {
        return usernr;
    }

    public static void setUsernr(int usernr) {
        User.usernr = usernr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBenutzername() {
        return benutzername;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.acc.setEmail(email);
    }

    public String getTelefonnumer() {
        return telefonnumer;
    }

    public void setTelefonnumer(String telefonnumer) {
        this.telefonnumer = telefonnumer;
        this.acc.setTelefonnummer(telefonnumer);
    }

    public String getGeburstdatum() {
        return geburstdatum;
    }

    public void setGeburstdatum(String geburstdatum) {
        this.geburstdatum = geburstdatum;
        this.acc.setGeburtsdatum(geburstdatum);
    }

    public long getFixeUserNr() {
        return fixeUserNr;
    }

    public void setFixeUserNr(long fixeUserNr) {
        this.fixeUserNr = fixeUserNr;
    }
    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public static void setUsernr(long usernr) {
        User.usernr = usernr;
    }

    public void einloggen(String benutzername, String passwort){
        acc.setEmail(this.email);
        acc.setGeburtsdatum(this.geburstdatum);
        acc.setTelefonnummer(this.telefonnumer);

        System.out.println("Du hast dich eingeloggen");
    }


}
