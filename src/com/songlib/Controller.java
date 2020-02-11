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

}
