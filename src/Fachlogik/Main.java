package Fachlogik;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

public class Main {
 public static void main (String []args) {

    //creating states for articles
     ArtikelZustand zustand1 = ArtikelZustand.AUSVERKAUFT;
     ArtikelZustand zustand2 = ArtikelZustand.AVAILABLE;

     //creating articles
     Artikel damUhr = new Damenuhr(186.0, "classic", zustand1, "Fossil",30);
     Artikel herrUhr = new Herrenuhr(500.0, "classic", zustand2,"Rolex", 42);
     Artikel armband = new Armband(50.0, "Leather", zustand2,"Daniel Wellington", 18, 2);

     //adding articles to the list
     ArtikelListe artikelListe = new ArtikelListe();
     artikelListe.addArtikel(damUhr,2);
     artikelListe.addArtikel(herrUhr,1);
     artikelListe.addArtikel(armband,1);
     artikelListe.removeArtikel(damUhr);



     //sorting the article list in ascending price order
     Collections.sort(artikelListe.getArtikelList());

//     System.out.println( artikelListe.druckeArtikelListe());
//     System.out.println("zu zahlender Betrag: "+artikelListe.betragBerechnen());

     //creatting Adresse, Fachlogik.Bestellung, Fachlogik.Warenkorb
    Adresse adresse = new Adresse("Kreisviertel",17,44147,"Dortmund");
    Zahlungsmethode lastchrift = new Lastschrift("Egal","3545","DEUTXX");
    lastchrift.setStatus(BestellungStatus.BEARBEITET);
    Bestellung bestellung = new Bestellung(lastchrift,artikelListe);
    Warenkorb warenkorb = new Warenkorb();

    //assign the created article list to the objects warenkorb and bestellung
    warenkorb.setArtikelListe(artikelListe);
    bestellung.setArtikelListe(artikelListe);

//    //create mew object Fachlogik.Account,
     String email ="tram.anh.1234@gmail.com";
//     Account acc = new Account(adresse,email);
//     acc.setName("Tram Anh Nguyen");

     //adding the order to account
//     acc.addBestellung(bestellung);
//     acc.bestellungSubscribe();
     //paying the bill
//     bestellung.getZahlungsmethode().bezahlen();
//     bestellung.bezahlen();

     System.out.println(bestellung.getBestellStatus());

     // create new object Rechnung
//     Rechnung rechnung = new Rechnung();
//     rechnung.setBestellung(bestellung);
//     rechnung.setAccount(acc);
//     rechnung.rechnungDrucke();

     //user subscribe to the product
//     damUhr.subscribe(acc);

     //changing the state of the article by adding more article
     Lager lager = new Lager();
//     lager.addArtikel(damUhr,2);

     //a file to save username and password
     Validator validator = new Validator();
     Besucher anonymous = new Besucher(validator);
     Besucher ano = new Besucher(validator);

     anonymous.registrieren("tramanh","student",adresse,email);
     ano.registrieren("tramanh","student",adresse,email);

     ano.setWarenkorb(warenkorb);
//     warenkorb.artikelZeigen();


 }
}
