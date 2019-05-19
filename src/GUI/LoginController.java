package GUI;


import Fachlogik.Adresse;
import Fachlogik.Besucher;
import Fachlogik.Validator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    Stage primaryStage;
    Validator validator = new Validator();
    Besucher besucher = new Besucher(validator);


    //loginForm
    @FXML
    AnchorPane rootPane;
    @FXML
    TextField txtUsername;
    @FXML
    TextField txtPasswort;

    //RegisForm
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
    public void login() throws IOException {
        besucher.einloggen(txtUsername.getText(), txtPasswort.getText());
        boolean valid = validator.loginValidate(txtUsername.getText(), txtPasswort.getText());
//        if (valid) {
//            Stage window = this.primaryStage;
//            Parent root = FXMLLoader.load(getClass().getResource("regis.fxml"));
//            window.setTitle("UserInfo");
//            window.setScene(new Scene(root,600,500));
//            window.show();
//            AnchorPane root = FXMLLoader.load(getClass().getResource("userInfo.fxml"));
//            this.rootPane.getChildren().setAll(root);
//        }
    }


    @FXML
    public void goToRegistrieren() throws IOException {
        primaryStage = new Stage();
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

    public void userSite() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
