package GUI;

import javafx.application.Application;
import javafx.stage.Stage;




public class GUITest extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginForm loginForm = new LoginForm();


        primaryStage.setTitle("OnlineShop-Einloggen");
        primaryStage.setScene(loginForm.getScene());

        primaryStage.setResizable(false);
        primaryStage.show();


    }
}
