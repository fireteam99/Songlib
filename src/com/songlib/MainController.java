package com.songlib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
        listView.setItems(observableList);
        listView.setCellFactory(songListView -> new SongListViewCell());
    }

    public void setListView() {

    }

    @FXML
    private Button addButton;

    @FXML
    private Text name;

    @FXML
    private Text artist;

    @FXML
    private Text album;

    @FXML
    private Text year;

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
