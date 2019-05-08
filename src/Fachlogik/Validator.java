package Fachlogik;

import sun.security.util.Password;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Validator {
    private HashMap<String,String> stringHashMap ;
    private Set<String> stringSet ;
    private File users ;

    public Validator() {
        this.stringHashMap = new HashMap<>();
        this.stringSet = new HashSet<>();
        this.users = new File("users.txt");
    }

    public boolean regisVerify(String benutzername){
        boolean validRegis = false;
        if(!stringSet.contains(benutzername)){
            validRegis = true;

        }
        return  validRegis;
    }
    public boolean loginVerify(String benutzername, String passwort) {
        boolean validLogin = false;
        Set<String> set = stringHashMap.keySet();
        for (String key : set) {
            if (benutzername.equals(key) && stringHashMap.get(benutzername).equals(passwort)) {
                validLogin = true;
            }

        }
        return validLogin;
    }

    public void addUser(User user){
        if(!stringSet.contains(user.getBenutzername())){
            stringHashMap.put(user.getBenutzername(),user.getPasswort());
            stringSet.add(user.getBenutzername());
            exportToFile();

        }

    }
    public void exportToFile() {
        try (FileWriter fileWriter = new FileWriter(users,false);
             BufferedWriter bw = new BufferedWriter(fileWriter)){
            for(Map.Entry<String, String> entries : this.stringHashMap.entrySet()){
                bw.write(entries.toString()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void changePassword(User user, String newPassword){
        stringHashMap.replace(user.getBenutzername(),newPassword);
        exportToFile();
        }
    }


