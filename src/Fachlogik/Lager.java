package Fachlogik;

import java.util.HashMap;

import java.util.Set;

public class Lager {

    private HashMap<Artikel,Integer> warenbestand;

    public HashMap<Artikel, Integer> getWarenbestand() {
        return warenbestand;
    }

    public Lager() {
        this.warenbestand = new HashMap<>();
    }

    public void setWarenbestand(HashMap<Artikel, Integer> warenbestand) {
        this.warenbestand = warenbestand;
    }

    //adding articles to the warehouse
    public void addArtikel(Artikel artikel, int anzahl){
        int total = anzahl + artikel.getAnfangBestand();
        System.out.println(artikel);
        warenbestand.put(artikel,total);
        Set<Artikel> artikelSet = warenbestand.keySet();
        for(Artikel article : artikelSet ){
            // if the article is out of stock,by adding new article to the warehouse the state of the article will change to "available"
            if(article.getZustand().toString().equals("AUSVERKAUFT") && anzahl!= 0 ){
                article.setZustand(ArtikelZustand.AVAILABLE);
            }
        }

    }
}
