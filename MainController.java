package GUI;


import Fachlogik.Adresse;
import Fachlogik.Besucher;
import Fachlogik.Validator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    Validator validator = new Validator();
    Besucher besucher = new Besucher(validator);

    @FXML
    TextField txtUsername;

    @FXML
    TextField txtPasswort;

    @FXML
    TextField benutzername;
    @FXML
    TextField passwort;
    @FXML
    TextField street;
    @FXML
    TextField hausnr;
    @FXML
    TextField plz;
    @FXML
    TextField city;
    @FXML
    TextField mail;
    @FXML
    CheckBox checkbox;


    //handle event for button login
    @FXML
    public void login() {
        besucher.einloggen(txtUsername.getText(), txtPasswort.getText());
    }

    @FXML
    public void goToRegistrieren() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("regis.fxml"));
        primaryStage.setTitle("Registrieren");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    @FXML
    public void registrieren() {
        int tmpthsnr = Integer.parseInt(hausnr.getText());
        int tmptPlz = Integer.parseInt(plz.getText());

        Adresse einAdresse = new Adresse(street.getText(), tmpthsnr, tmptPlz, city.getText());
        if (checkbox.isSelected()) {
            besucher.registrieren(benutzername.getText(), passwort.getText(), einAdresse, mail.getText());
//            primaryStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Bitte bestätigen Sie die absendenen Informationen");

            alert.showAndWait();
        }
    }
    public void userSite(){

    }
}
