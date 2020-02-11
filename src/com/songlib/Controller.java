package com.songlib;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    //----Main menu (listview)
    @FXML
    private ListView<?> songList;

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
    void createNewSong(ActionEvent event) {

    }

    @FXML
    void editSong(ActionEvent event) {

    }
    //----end of main menu (listview)


    //----add new song page
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
    void cancelAddingSong(ActionEvent event) {

    }

    @FXML
    void submitNewSong(ActionEvent event) {

    }
    //----end of add new song page


    //----edit song page
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
    void cancelEditSong(ActionEvent event) {

    }

    @FXML
    void updateSong(ActionEvent event) {

    }
    //----end of edit song page





}
