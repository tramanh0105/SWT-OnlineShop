package Fachlogik;

import java.util.*;
import java.util.stream.Collectors;

public class ArtikelListe {
    private List<Artikel> artikelList;
    private HashMap<Artikel, Integer> artikelHashMap;

    public ArtikelListe() {
        artikelList = new ArrayList<>();
        artikelHashMap = new HashMap<>();
    }

    public HashMap<Artikel, Integer> getArtikelHashMap() {
        return artikelHashMap;
    }

    public void setArtikelHashMap(HashMap<Artikel, Integer> artikelHashMap) {
        this.artikelHashMap = artikelHashMap;
    }

    public List<Artikel> getArtikelList() {
        return artikelList;
    }

    public void setArtikelList(List<Artikel> artikelList) {
        this.artikelList = artikelList;
    }

    public void addArtikel(Artikel artikel, int stückAnzahl) {
        if(artikel.getZustand().toString().equals("AVAILABLE")) {
            for (int i = 0; i < stückAnzahl; i++) {
                artikelList.add(artikel);
            }
//        int anzahl = artikelHashMap.get(artikel);
            int anzahl = 0;
            anzahl += stückAnzahl;
            artikelHashMap.put(artikel, anzahl);
        }
    }

    public void removeArtikel(Artikel artikel) {
        if (artikelList.contains(artikel))
            artikelList.remove(artikel);
    }

    public double betragBerechnen() {
        double betrag = 0;
        Set<Artikel> artikelSet = artikelHashMap.keySet();

        for (Artikel a : artikelSet) {
            betrag += a.getPreis() * artikelHashMap.get(a);
        }
        return betrag;
    }

    public String druckeArtikelListe() {

        String list = "";
        for (Artikel a : artikelList) {
            list += a.toString() + "\n";
        }
        return list;
    }
    public List filter(String classname){
        List<Artikel> filteredList =this.artikelList.stream().filter(a-> a.getClass().getSimpleName().equals(classname)).collect(Collectors.toList());

        return filteredList;


    }

}
