package com.songlib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class MainController {

    //----Main menu (listview)
    private Stage stage;

    @FXML
    BorderPane borderPane;

    @FXML
    private ListView<Song> listView;
    private ObservableList<Song> observableList;

    public MainController() throws FileNotFoundException {
        SongList songList = new SongList();
        songList.createSong(new Song( "michael Jackson", "THis is it", "Hi", "2017"));
        ArrayList<Song> songs = songList.getSongs();
        observableList = FXCollections.observableList(songs);
    }

    public void initialize() throws FileNotFoundException {
        // generates the list
        listView.setItems(observableList);
        listView.setCellFactory(songListView -> new SongListViewCellController());
        // event handler for song selection
        listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> renderSelectedSong());
        // select the first item if the list is not empty
        if (!observableList.isEmpty()) {
            listView.getSelectionModel().select(0);
        }
    }

    public void refreshSongList() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs = songList.getSongs();
        observableList.removeAll(observableList);
        for (Song song: songs) {
            observableList.add(song);
        }
    }

    public void renderSelectedSong() {
        Song selectedSong = listView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            albumCover.setImage(new Image(new File("resources/album_cover_placeholder.png").toURI().toString()));
            name.setText(selectedSong.getName());
            artist.setText(selectedSong.getArtist());
            album.setText(selectedSong.getAlbum());
            year.setText(selectedSong.getYear());
        }
    }

    @FXML
    private Button createButton;

    @FXML
    public void createSong(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("create.fxml"));
            Parent root = loader.load();

            Node n = (Node) event.getSource();
            Stage stage=(Stage) n.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    private Button editButton;

    @FXML
    public void editSong(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("edit.fxml"));
            Parent root = loader.load();

            EditController ectr = loader.getController();
            ectr.currSong(listView.getSelectionModel().getSelectedItem().getId());
            Node n = (Node) event.getSource();
            Stage stage=(Stage) n.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private Button deleteButton;

    @FXML
    public void deleteSong(ActionEvent event) throws FileNotFoundException {
        Song selectedSong = listView.getSelectionModel().getSelectedItem();
        SongList songList = new SongList();
        songList.deleteSong(selectedSong.getId());
        // we want the changes on file to update
        refreshSongList();
    }

    public void selectSong(String id) throws FileNotFoundException {
        refreshSongList();
        List<Song> filter = observableList.stream().filter(song -> song.getId().equals(id)).collect(Collectors.toList());
        if (filter.isEmpty()) {
            throw new NoSuchElementException("The requested song does not exist.");
        }
        listView.getSelectionModel().select(filter.get(0));
    }

    //----end of main menu (listview)


}
