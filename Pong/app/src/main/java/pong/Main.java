// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    public void start(Stage stage) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("/View.fxml"));
            Scene scene     = new Scene(root);

            stage.setResizable(false);
            stage.setTitle("Pong");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
