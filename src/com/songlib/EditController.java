package com.songlib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.songlib.Song;

import java.io.FileNotFoundException;

public class EditController {

    private String songid;

    @FXML
    private TextField editNameBox;

    @FXML
    private TextField editArtistBox;

    @FXML
    private TextField editAlbumBox;

    @FXML
    private TextField editYearBox;

    @FXML
    private Button submitEdit;

    @FXML
    private Button cancelEdit;

    @FXML
    public void cancelEditSong(ActionEvent event) throws Exception {
        Node n = (Node) event.getSource();
        Stage stage=(Stage) n.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void updateSong(ActionEvent event) throws Exception{ //this is the "submit" button

        //**return id as well

        //----coding starts here...----//
        String name = editNameBox.getText();
        String artist = editArtistBox.getText();
        String album = editAlbumBox.getText();
        String year = editYearBox.getText();

        //now update Song object --> this updates the temp copy, must set song obj to temp
        Song temp = new Song();
        temp.setName(name);
        temp.setArtist(artist);
        temp.setAlbum(album);
        temp.setYear(year);

        //after update is successful, go back to main page
        Node n = (Node) event.getSource();
        Stage stage=(Stage) n.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    //**need to create EditController instance in MainController object when we click on editSong
    //**then call currSong method with that instance, passing in the Song object.
    //must be called in MainController
    public void currSong(String id) throws FileNotFoundException { //this just gets the instance that was passed in, and fills textfields
        SongList sl = new SongList();
        Song song = sl.getSong(id);
        editNameBox.setText(song.getName());
        editAlbumBox.setText(song.getAlbum());
        editArtistBox.setText(song.getArtist());
        editYearBox.setText(song.getYear());
    }


}

