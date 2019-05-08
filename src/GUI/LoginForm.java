package GUI;

import Fachlogik.Besucher;
import Fachlogik.Validator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



public class LoginForm {
    private TextField txtUserName;
    private PasswordField pf;
    private RegisForm regi;
    private Besucher besucher;
//    private Validator validator;

    public LoginForm(Validator validator) {

        this.besucher = new Besucher(validator);
        this.regi = new RegisForm(besucher);
    }

    public TextField getTxtUserName() {
        return txtUserName;
    }

    public PasswordField getPf() {
        return pf;
    }

    public Scene getScene() {
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));

        //Adding HBox
        HBox hb = new HBox();
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hb.setPadding(new Insets(30, 30, 30, 30));

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30,30, 30, 30));
        gridPane.setHgap(10);
        gridPane.setVgap(20);



        //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        this.txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        this.pf = new PasswordField();
        Button btnLogin = new Button("Login");
        Button btnregis = new Button("Registrieren");
//        final Label lblMessage = new Label();
        Button btnfortsetzen = new Button("Fortsetzen als Anonymous");
        hBox.getChildren().addAll(btnLogin, btnregis, btnfortsetzen);

        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0, 2, 1);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(hBox, 1, 2);

        GridPane.setHgrow(hBox, Priority.ALWAYS);
        GridPane.setVgrow(hBox, Priority.ALWAYS);

        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);


        //Adding text and DropShadow effect to it
        Text text = new Text("Sign up");
        text.setFont(Font.font("Varela Round", FontWeight.BOLD, 30));
        text.setEffect(dropShadow);


        //Adding text to HBox
        hb.getChildren().add(text);
        hb.setAlignment(Pos.TOP_CENTER);

        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("button");
        btnregis.setId("button");
        btnfortsetzen.setId("button");
        text.setId("text");
        text.setFill(Color.WHITE);


        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);
//        bp.setCenter(imageView);
//        bp.setBackground(background);

        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(bp,550,250);
        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style.css").toExternalForm());

        // adding functionalitis for the buttons
        btnregis.setOnAction(e -> regi.display());
        btnLogin.setOnAction(e -> {
            String tmptUsername = this.txtUserName.getText();
            String tmptpass = this.pf.getText();
            this.besucher.einloggen(tmptUsername, tmptpass);


        });
        return scene;
    }

}
