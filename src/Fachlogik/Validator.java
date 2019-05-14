package Fachlogik;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private HashMap<String,String> stringHashMap ;
    private Set<String> stringSet ;
    private File users ;

    public Validator() {
        this.stringHashMap = new HashMap<>();
        this.stringSet = new HashSet<>();
        this.users = new File("database/users.txt");
    }
    public void speichern(){
        try (FileOutputStream fos = new FileOutputStream(this.users);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.stringHashMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void laden(){
        try (FileInputStream  fis = new FileInputStream(this.users);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            this.stringHashMap = (HashMap<String, String>) ois.readObject();
            this.stringSet = this.stringHashMap.keySet();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean regisValidate(String benutzername){

        if(this.users.length()!=0){
            laden();
        }

        boolean validRegis = false;
        if(!stringSet.contains(benutzername)){
            validRegis = true;

        }
        return  validRegis;
    }
    public boolean loginValidate(String benutzername, String passwort) {
        //if file is not empty, we load the data from the file
        if(this.users.length()!=0) {
            laden();
        }
        boolean validLogin = false;
        if (this.stringHashMap.containsKey(benutzername) && this.stringHashMap.get(benutzername).equals(passwort)){
            validLogin = true;

    }
//        Set<String> set = stringHashMap.keySet();
//        for (String key : set) {
//            if (benutzername.equals(key) && stringHashMap.get(benutzername).equals(passwort)) {
//                validLogin = true;
//            }
//
//        }
        return validLogin;
    }

    public void addUser(User user){
        if(!stringSet.contains(user.getBenutzername())){
            stringHashMap.put(user.getBenutzername(),user.getPasswort());
            stringSet.add(user.getBenutzername());
            speichern();
//            exportToFile();

        }

    }
//    public void exportToFile() {
//        try (FileWriter fileWriter = new FileWriter(users,false);
//             BufferedWriter bw = new BufferedWriter(fileWriter)){
//            for(Map.Entry<String, String> entries : this.stringHashMap.entrySet()){
//                bw.write(entries.toString()+"\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    public void changePassword(User user, String newPassword){
        stringHashMap.replace(user.getBenutzername(),newPassword);
//        exportToFile();
        speichern();
        }
    }


