package Fachlogik;


import javafx.scene.control.Alert;


public class Besucher {


    private Warenkorb warenkorb;
    private Validator validator;


    public Besucher(Validator validator) {
        this.validator = validator;
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }


    public Warenkorb getWarenkorb() {
        return warenkorb;
    }

    public void setWarenkorb(Warenkorb warenkorb) {
        this.warenkorb = warenkorb;
    }


//    public boolean  verify(String benutzername, String passwort){
//        String usertest =benutzername+","+passwort;
//        try (FileReader fileReader = new FileReader(users);
//             BufferedReader br = new BufferedReader(fileReader)){
//            String line;
//            while ((line = br.readLine()) != null) {
//                if(usertest.equals(line)){
//                    return true;
//                }
//            }//end while
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public void registrieren(String benutzername, String passwort, Adresse adresse, String email) {
        boolean valid;
        valid = this.validator.regisValidate(benutzername);
        if (valid == true) {
            User newUser = new User(this.validator, benutzername, passwort, adresse, email);
            newUser.setValidator(this.validator);
            System.out.println("Du hast dich erfolgreich registriert.");
        } else {
            System.out.println("Die eingegebene benutzername ist bereits vergeben.");
        }

//        String benutzer = benutzername + "," + passwort+"\n";
//        String temptline;
//        boolean exist = false;
//        exist = verify(benutzername,passwort);
//
//            if (exist == false) {
//                try (FileWriter fileWriter = new FileWriter(users, false);
//                     BufferedWriter bw = new BufferedWriter(fileWriter)) {
//                    User newUser = new User(benutzername, passwort, adresse, email);
//                    bw.write(benutzer);
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //assign the email to the account information
//            if (exist == false) {
//                System.out.println("Du hast erforgreich registriert");
//            } else {
//                System.out.println("Die eingegebene Benutzername und Passwort sind schon bereits vergeben");
//            }
    }

    public void einloggen(String benutzername, String passwort) {
        boolean found = false;
        found = this.validator.loginValidate(benutzername, passwort);
        if (found == true) {
//            System.out.println("Du hast dich erfolgreich eingeloggen");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Hallo, " + benutzername);
            alert.setContentText("Du hast dich erfolgreich eingeloggen");

            alert.showAndWait();
        } else {
            System.out.println("Die Benutzername oder Passwort ist falsch eingegeben.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Fehler");
            alert.setContentText("Die Benutzername oder Passwort ist falsch eingegeben.");

            alert.showAndWait();
        }
    }
}
//
//        try (FileReader fileReader = new FileReader(users);
//             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//            // while its not the end of the file and we havent found matched username and password yet, loop through
//            //the file and compare the values
//            while (bufferedReader.readLine() != null && !found) {
//                String temp = bufferedReader.readLine();
//                String[] user = temp.split(",");
//                tempBenutzername = user[0];
//                tempPasswort = user[1];
//                if (benutzername.equals(tempBenutzername) && passwort.equals(tempPasswort)) {
//                    found = true;
//                    System.out.println("Du hast dich erfolgreich eingeloggen");
//                }
//            }// end while
//            System.out.println("Die eingegebene Benutzername oder Passwort ist falsch");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



