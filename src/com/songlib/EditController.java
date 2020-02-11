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

public class EditController {

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
    public void updateSong(ActionEvent event, MainController song) { //assuming we recieved song obj from MainController

        //should get a song id from the MainController --> MainController will pass in an id for the
        //song that we want to edit.

        //once we have the id, we can auto fill the text fields with the current data (i.e. name, artist,...)
        //and let the user edit as desired

        //clicking the "update" button will update the song directly, which will then have to update the json file

        //----coding starts here...----//

        // autofill selected song's data (using get methods from MainController)
        this.editNameBox = song.getName();
        this.editArtistBox = song.getArtist();
        this.editAlbumBox = song.getAlbum();
        this.editYearBox = song.getYear();

        //now to allow user to edit the text in textbox


    }

}

