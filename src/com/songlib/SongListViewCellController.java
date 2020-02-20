/*Ray Sy, Robert Cheng*/
package com.songlib;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;

public class SongListViewCellController extends ListCell<Song> {
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
                imageView.setImage(new Image(new File("resources/album_cover_placeholder.png").toURI().toString()));
            } else {
                setText(null);
                setGraphic(null);
            }
            if (nameLabel != null) {
                nameLabel.setText(String.valueOf(song.getName()));
            } else {
                setText(null);
                setGraphic(null);
            }
            if (artistLabel != null) {
                artistLabel.setText(String.valueOf(song.getArtist()));
            } else {
                setText(null);
                setGraphic(null);
            }
            setText(null);
            setGraphic(hBox);
        }
    }
}
