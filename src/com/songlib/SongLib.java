/*Ray Sy, Robert Cheng*/
package com.songlib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SongLib extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        primaryStage.setTitle("Songlib");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);
        primaryStage.show();
    }

}
