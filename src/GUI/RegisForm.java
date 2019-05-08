package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class RegisForm {
    public Scene getScene(){
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));

        //adding HBox
        HBox hb = new HBox();
        hb.setSpacing(15);

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
        Label user = new Label ("Benutzername: ");
        TextField username = new TextField();
        Label pass = new Label ("Passwort: ");
        PasswordField passwort = new PasswordField();
        Label adress = new Label("Adresse:");
        TextField street = new TextField("Straße");
        TextField nr = new TextField("Hausnummer");
        TextField plz = new TextField("PLZ");
        Label email = new Label ("Email: ");
        TextField mail = new TextField();
        CheckBox checkbox = new CheckBox("bestätigen");
        Button btn = new Button("Absenden");
        Text text = new Text("Registrieren");
        text.setFont(Font.font("Varela Round", FontWeight.BOLD, 30));
        text.setEffect(dropShadow);

        //Adding nodes to HBox
        hb.getChildren().addAll(adress,street,nr,plz);

        //Adding nodes to gridPane
        gp.add(user,0,0);
        gp.add(username,1,0);
        gp.add(pass,0,1);
        gp.add(passwort,1,1);
        gp.add(hb,0,2);
        gp.add(email,0,3);
        gp.add(mail,1,3);
        gp.add(checkbox,0,4);
        gp.add(btn,1,4);

        //adding elements to BorderPane
        bp.setTop(text);
        bp.setCenter(gp);

        //adding scene
        Scene scene = new Scene(bp,500,500);
        return scene;
    }
}
