package Fachlogik;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private static long account_id =1;
    private Warenkorb warenkorb;
    private String email;
    private String geburtsdatum;
    private String telefonnummer;
    private String name;
    private Adresse adress;
    private List<Bestellung> bestellungList;
    private long fixeAccountID;

    public Account(Adresse adress) {
        this.adress = adress;
        this.bestellungList = new ArrayList<>();
        this.warenkorb = new Warenkorb();
        this.fixeAccountID = account_id;
        account_id ++;
    }

    public Warenkorb getWarenkorb() {
        return warenkorb;
    }

    public void setWarenkorb(Warenkorb warenkorb) {
        this.warenkorb = warenkorb;
    }

    public static long getAccount_id() {
        return account_id;
    }

    public static void setAccount_id(long account_id) {
        Account.account_id = account_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setAdress(Adresse adress) {
        this.adress = adress;
    }

    public long getFixeAccountID() {
        return fixeAccountID;
    }

    public void setFixeAccountID(long fixeAccountID) {
        this.fixeAccountID = fixeAccountID;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adresse getAdress() {
        return adress;
    }

    public void adressändern(Adresse adress) {
        this.adress = adress;
    }

    public List<Bestellung> getBestellungList() {
        return bestellungList;
    }

    public void setBestellungList(List<Bestellung> bestellungList) {
        this.bestellungList = bestellungList;
    }

    public void bestellungAbbrechen(Bestellung bestellung) {
        if (bestellung != null)
            bestellung = null;
    }



    @Override
    public String toString() {
        return "Kunde {" +
                "name='" + name + '\'' +
                ", fixeAccountID=" + fixeAccountID +
                '}';
    }
}
