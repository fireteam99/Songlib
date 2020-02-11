package com.songlib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent root = (Parent)loader.load();

        // load main controller
        MainController mainController = loader.getController();
        mainController.start(primaryStage);

        primaryStage.setTitle("Welcome to Songlib");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
    }

}
