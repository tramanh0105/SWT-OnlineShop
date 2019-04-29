package Fachlogik;

import Fachlogik.ArtikelListe;

public class Warenkorb {
    private ArtikelListe artikelListe;
    private static int warenkorb_id = 1;
    private int fixewarenkorbID;

    public Warenkorb() {
        this.fixewarenkorbID = warenkorb_id;
        warenkorb_id ++;
    }

    public ArtikelListe getArtikelListe() {
        return artikelListe;
    }

    public void setArtikelListe(ArtikelListe artikelListe) {
        this.artikelListe = artikelListe;
    }

    public static int getWarenkorb_id() {
        return warenkorb_id;
    }

    public static void setWarenkorb_id(int warenkorb_id) {
        warenkorb_id = warenkorb_id;
    }
    public void addArtikelListe(){
        artikelListe = new ArtikelListe();
    }

    public void deleteArtikelListe(){
        if(artikelListe != null){
            artikelListe = null;
        }
    }

}
