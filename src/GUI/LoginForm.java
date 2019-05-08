package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginForm {
    private TextField txtUserName;
    private PasswordField pf;
    private RegisForm regi ;

    public LoginForm() {
        this.regi = new RegisForm();
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
        hb.setPadding(new Insets(20, 20, 20, 30));

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(10);

        //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        this.txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        this.pf = new PasswordField();
        Button btnLogin = new Button("Login");
        Button regis = new Button("Registrieren");
//        final Label lblMessage = new Label();
        Button fortsetzen = new Button("Fortsetzen als Anonymous");
        hBox.getChildren().addAll(btnLogin, regis,fortsetzen);

        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0,2 ,1);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(hBox, 1, 2);



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
        btnLogin.setId("btnLogin");
        text.setId("text");

//        Image image = new Image("file:images/bg.jfif");
//
//        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
//
//        Background background = new Background(new BackgroundImage(image,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.CENTER,
//                bSize));



        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);
//        bp.setCenter(imageView);
//        bp.setBackground(background);

        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(bp);
//        scene.getStylesheets().add("login.css");
//        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());

        // adding functionalitis for the buttons
//        btnLogin.setOnAction(e->{
//            scene
//        });
        return scene;
    }

}
