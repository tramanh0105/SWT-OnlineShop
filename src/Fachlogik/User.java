package Fachlogik;

import java.io.*;
import java.util.Objects;

public class User extends Besucher implements Serializable{
    private String benutzername;
    private String passwort;
    private static long usernr;
    private Account acc;
    private long fixeUserNr;
    private File userFile ;



    public User(Validator validator,String benutzername, String passwort, Adresse adresse, String email) {
        super(validator);
        this.benutzername = benutzername;
        this.acc = new Account(adresse, email);
        this.passwort = passwort;
        fixeUserNr = usernr;
        usernr++;
        this.userFile = new File("database/UserData/"+this.benutzername+".txt");
        acc.userSpeichern(this.userFile);
        validator.addUser(this);
//        new File(filePath).mkdirs();
//        this.acc.createFiles(filePath);
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

//    public Validator getValidator() {
//        return validator;
//    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
        super.getValidator().changePassword(this,passwort);
    }

//    public void setValidator(Validator validator) {
//        this.validator = validator;
//    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public static long getUsernr() {
        return usernr;
    }

    public static void setUsernr(long usernr) {
        User.usernr = usernr;
    }

    public long getFixeUserNr() {
        return fixeUserNr;
    }

    public void setFixeUserNr(long fixeUserNr) {
        this.fixeUserNr = fixeUserNr;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return fixeUserNr == user.fixeUserNr &&
                benutzername.equals(user.benutzername) &&
                passwort.equals(user.passwort) &&
                Objects.equals(acc, user.acc) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(benutzername, passwort, acc, fixeUserNr);
    }
}
