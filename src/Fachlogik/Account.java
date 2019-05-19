package Fachlogik;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Account implements Observer, Serializable {
    private static long account_id = 1;
    private Warenkorb warenkorb;
    private String email;
    private String geburtsdatum;
    private String telefonnummer;
    private String name;
    private Adresse adress;
    private List<Bestellung> bestellungList;
    private long fixeAccountID;
//    private File orders;


    public Account(Adresse adress, String email) {
        this.adress = adress;
        this.bestellungList = new ArrayList<>();
        this.warenkorb = new Warenkorb();
        this.email = email;
        this.fixeAccountID = account_id;
        account_id++;
//        orders = new File(this.filePath+"/order.txt");
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


    // user would be informed if there is any update about the order status
    public void bestellungSubscribe() {

        for (Bestellung bestell : bestellungList) {
            bestell.addObserver(this);
        }
    }

    //create new file for storing orders info
//    public void createFiles(String filePath) {
////        if (orders!= null) {
////            this.orders = new File(filePath + "/order.txt");
////
////        }
//        if(userinfo !=null){
//            this.userinfo = new File(filePath +"/info.txt");
//        }
//
//
//    }

    public void addBestellung(Bestellung bestellung) {
        if (!bestellungList.contains(bestellung)) {
            this.bestellungList.add(bestellung);

        }

    }

    public void bestellungAbbrechen(Bestellung bestellung) {

            this.bestellungList.remove(bestellung);

    }

//    public void bestellungspeichern() {
//        //save the ordersobject to the orders file
//        try (FileOutputStream fos = new FileOutputStream(this.orders);
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(this.bestellungList);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        //save the accounts information to the userInfo file
       public void accSpeichern(File file){
            try(FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos) ){
                oos.writeObject(this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        try (FileWriter fileWriter = new FileWriter(this.orders, false);
//             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
//            bufferedWriter.write(bestellung.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//    public void bestellungladen() {
//        try (FileInputStream fis = new FileInputStream(this.orders);
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            this.bestellungList=(List<Bestellung>) ois.readObject();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        public Account accLaden(File file ){
        Account acc = null ;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

             acc = (Account) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return acc;
    }

    @Override
    public String toString() {
        return "Account{" +
                " Warenkorb=" + warenkorb +
                ", email='" + email + '\'' +
                ", geburtsdatum='" + geburtsdatum + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                ", name='" + name + '\'' +
                ", adress=" + adress +
                ", bestellungList=" + bestellungList +
                ", fixeAccountID=" + fixeAccountID +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Artikel) {
            JOptionPane.showMessageDialog(null, "Das gewünschte Artikel ist wieder verfügbar");
        }
        if (o instanceof Bestellung) {
            JOptionPane.showMessageDialog(null, "Die Bestellung ist " + ((Bestellung) o).getBestellStatus().toString().toLowerCase());
        }
    }
}
