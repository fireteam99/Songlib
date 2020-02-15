package com.songlib;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.songlib.Song;


public class MainController {

    //----Main menu (listview)
    @FXML
    BorderPane borderPane;

    @FXML
    private ListView<Song> listView;
    private ObservableList<Song> observableList;

    public MainController() {
        // TODO: read the saved songs from json file
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Test1", "John Doe", "Test1", "2020"));
        songs.add(new Song("Test2", "Jane Smith", "Test2", "2019"));
        songs.add(new Song("Test3", "Kanye", "Test3", "2017"));
        // add to observablelist
        observableList = FXCollections.observableList(songs);
    }

    public void initialize() {
        // generates the list
        listView.setItems(observableList);
        listView.setCellFactory(songListView -> new SongListViewCell());
        // event handler for song selection
        listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> renderSelectedSong());
        // select the first item
        listView.getSelectionModel().select(0);
    }

    public void renderSelectedSong() {
        Song selectedSong = listView.getSelectionModel().getSelectedItem();
        albumCover.setImage(new Image("https://i1.sndcdn.com/artworks-000272021369-bx64j7-t500x500.jpg"));
        name.setText(selectedSong.getName());
        artist.setText(selectedSong.getArtist());
        album.setText(selectedSong.getAlbum());
        year.setText(selectedSong.getYear());
    }

    @FXML
    private Button addButton;

    @FXML
    private ImageView albumCover;

    @FXML
    private Label name;

    @FXML
    private Label artist;

    @FXML
    private Label album;

    @FXML
    private Label year;

    @FXML
    private Button editOption;

    @FXML
    public void createNewSong(ActionEvent event) {

    }

    @FXML
    public void editSong(ActionEvent event) {

    }

    //----end of main menu (listview)


}
