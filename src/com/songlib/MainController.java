package com.songlib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

import com.songlib.Song;

public class MainController {

    //----Main menu (listview)
    @FXML
    ListView<String> songList;
    private ObservableList<String> observableList;

    public void start(Stage mainStage) {
        // TODO: read the saved songs from json file
//        ArrayList<Song> songs = new ArrayList<>();
//        songs.add(new Song("Test1", "John Doe", "Test1", "2020"));
//        songs.add(new Song("Test2", "Jane Smith", "Test2", "2019"));
//        songs.add(new Song("Test3", "Kanye", "Test3", "2017"));
        // cast the arraylist to observablelist
        observableList = FXCollections.observableArrayList(
                "Giants",
                "Patriots",
                "49ers",
                "Rams",
                "Packers",
                "Colts",
                "Cowboys",
                "Broncos",
                "Vikings",
                "Dolphins",
                "Titans",
                "Seahawks",
                "Steelers",
                "Jaguars");

        songList.setItems(observableList);
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
