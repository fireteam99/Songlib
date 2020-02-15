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

        //**cannot pass in another parameter, gives error in fxml file

        //should get a song id from the MainController --> MainController will pass in an id for the
        //song that we want to edit.

        //once we have the id, we can auto fill the text fields with the current data (i.e. name, artist,...)
        //and let the user edit as desired

        //clicking the "update" button will update the song directly, which will then have to update the json file

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
        //temp = //Song obj with songid ***;

        //check for bad input in year field ***

        //check for duplicates - call checkDuplicates method***

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
    public void currSong(Song song){ //this just gets the instance that was passed in, and fills textfields
        songid = song.getId();
        editNameBox.setText(song.getName());
        editArtistBox.setText(song.getArtist());
        editAlbumBox.setText(song.getAlbum());
        editYearBox.setText(song.getYear());
    }
    public Boolean checkDuplicates(Song song){
        //will go thru songlist and check to see if this song already exists

        return false;
    }


}

