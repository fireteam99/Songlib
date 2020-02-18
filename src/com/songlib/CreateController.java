package com.songlib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.songlib.MainController; //**

import java.io.IOException;
import java.util.regex.Pattern;

public class CreateController {

    @FXML
    private Button cancelAddButton;

    @FXML
    private Button submitAddButton;

    @FXML
    private TextField nameTxtBox;

    @FXML
    private TextField artistTxtBox;

    @FXML
    private TextField albumTxtBox;

    @FXML
    private TextField yearTxtBox;

    @FXML
    public void cancelAddingSong(ActionEvent event) throws Exception{
        Node n = (Node) event.getSource();
        Stage stage=(Stage) n.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root, 750, 500);;
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void submitNewSong(ActionEvent event) throws Exception{

        //**----do stuff----**//

        //read in user input
        String name = nameTxtBox.getText();
        String artist = artistTxtBox.getText();
        String album = albumTxtBox.getText();
        String year = yearTxtBox.getText();


        //check for duplicates -- iterate through songList***

        Song newSong = new Song(name,artist,album,year); //create new song obj with given input
        SongList sl = new SongList();
        try {
            sl.createSong(newSong);
        }
        catch (IllegalArgumentException i){
            Alert badInput = new Alert(Alert.AlertType.INFORMATION);
            Button b = (Button) event.getSource();
            Stage stage = (Stage) b.getScene().getWindow();
            badInput.initOwner(stage);

            badInput.setTitle("Error.");
            String content = i.getMessage();
            badInput.setContentText(content);
            badInput.showAndWait();

        }

        //----end of stuff----//
        //goes back to main page upon submission
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root = loader.load();

            MainController mctr = loader.getController();
            mctr.selectSong(newSong.getId());
            Node n = (Node) event.getSource();
            Stage stage=(Stage) n.getScene().getWindow();
            Scene scene = new Scene(root, 750, 500);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
