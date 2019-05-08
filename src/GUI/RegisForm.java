package GUI;

import Fachlogik.Adresse;
import Fachlogik.Besucher;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisForm {
    private Besucher besucher ;
    private TextField username;
    private PasswordField passwort;
    private TextField street;
    private TextField nr;
    private TextField plz;
    private TextField mail;
    private TextField stadt;

    public RegisForm(Besucher besucher) {
        this.besucher = besucher;
    }

    public void display() {
        Stage window = new Stage();
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(50, 50, 50, 50));

        //adding HBox
        HBox hBox = new HBox();
        HBox hb = new HBox();

        hb.setSpacing(15);
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(30,30,30,30));

        //Adding GridPane
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20, 20, 20, 20));
        gp.setHgap(5);
        gp.setVgap(10);
        //Drop Shadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //adding control nodes
        Label user = new Label("Benutzername: ");
        this.username = new TextField();
        Label pass = new Label("Passwort: ");
        this.passwort = new PasswordField();
        Label adress = new Label("Adresse: ");
        this.street = new TextField();
        street.setPromptText("Straße: ");
        this.nr = new TextField();
        nr.setPromptText("Hausnummer: ");
        this.plz = new TextField();
        plz.setPromptText("PLZ: ");
        this.stadt = new TextField();
        stadt.setPromptText("Stadt: ");
        Label email = new Label("Email: ");
        this.mail = new TextField();
        CheckBox checkbox = new CheckBox("bestätigen");
        Button btn = new Button("Absenden");
        Text text = new Text("Registrieren");
        text.setFont(Font.font("Varela Round", FontWeight.BOLD, 30));
        text.setEffect(dropShadow);

        //Adding nodes to HBox
        hb.getChildren().addAll(street, nr, plz,stadt);
        hBox.getChildren().add(text);
        //Adding nodes to gridPane
        gp.add(user, 0, 0);
        gp.add(username, 1, 0);
        gp.add(pass, 0, 1);
        gp.add(passwort, 1, 1);
        gp.add(adress, 0, 2);
        gp.add(hb, 1, 2);
        gp.add(email, 0, 3);
        gp.add(mail, 1, 3);
        gp.add(checkbox, 1, 4);
        gp.add(btn, 1, 5);
        GridPane.setHgrow(passwort, Priority.ALWAYS);
        //adding elements to BorderPane
        bp.setTop(text);
        bp.setCenter(gp);

        //adding scene
        Scene scene = new Scene(bp);
        window.setScene(scene);

        //adding id to nodes
        bp.setId("bp");
        gp.setId("root");
        btn.setId("button");
        text.setId("text");
        text.setFill(Color.WHITE);

        //link to css file
        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style.css").toExternalForm());

        //adding functionalities to controls
        btn.setOnAction(e->{
            String tmpname = username.getText();
            String tmppassword = passwort.getText();
            String tmpstreet = street.getText();
            int hsnr = Integer.parseInt(nr.getText()) ;
            int postlz = Integer.parseInt(plz.getText());
            String tmpstadt = stadt.getText();
            String einMail = mail.getText();
            Adresse einAdresse = new Adresse(tmpstreet,hsnr,postlz,tmpstadt);

            if(checkbox.isSelected()) {
                besucher.registrieren(tmpname,tmppassword,einAdresse,einMail);
                window.close();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Bitte bestätigen Sie die absendenen Informationen");

                alert.showAndWait();
            }
        });
        window.show();
    }
}
