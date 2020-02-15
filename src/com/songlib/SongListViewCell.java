package com.songlib;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class SongListViewCell extends ListCell<Song> {
    private FXMLLoader loader;
    @FXML
    private HBox hBox;
    @FXML
    private ImageView imageView;
    @FXML
    private Label nameLabel;
    @FXML
    private Label artistLabel;

    @Override
    protected void updateItem(Song song, boolean empty) {
        super.updateItem(song, empty);
        if (empty || song == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (loader == null) {
                loader = new FXMLLoader(getClass().getResource("SongListViewCell.fxml"));
                // you have to set it here because there are multiple instances
                loader.setController(this);
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (imageView != null) {
                imageView.setImage(new Image("https://i1.sndcdn.com/artworks-000272021369-bx64j7-t500x500.jpg"));
            }
            if (nameLabel != null) {
                nameLabel.setText(String.valueOf(song.getName()));
            }
            if (artistLabel != null) {
                artistLabel.setText(String.valueOf(song.getArtist()));
            }
        }
        setText(null);
        setGraphic(hBox);
    }
}