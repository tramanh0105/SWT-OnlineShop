package GUI;

import Fachlogik.Validator;
import javafx.application.Application;
import javafx.stage.Stage;


public class GUITest extends Application {
    Validator validator = new Validator();
    LoginForm loginForm = new LoginForm(validator);
    public static void main(String[] args) {
        launch();

    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("OnlineShop-Einloggen");
        primaryStage.setScene(loginForm.getScene());

//        primaryStage.setResizable(false);
        primaryStage.show();


    }
}
