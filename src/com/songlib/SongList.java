package com.songlib;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SongList {
    private  ArrayList<Song> songList;
    // checks to make sure the storage file exists otherwise create it
    private void init() throws FileNotFoundException {
        Boolean fileExists = false;
        try {
            Files.createFile(Paths.get("./storage.json"));
        } catch (FileAlreadyExistsException ignored) {
            fileExists = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileExists) {
            // read from the file
            Gson gson = new Gson();
            songList = gson.fromJson(new FileReader("./storage.json"), new TypeToken<List<Song>>(){}.getType());
            if (songList == null) {
                songList = new ArrayList<Song>();
            }
        } else {
            songList = new ArrayList<Song>();
        }
    }
    public ArrayList<Song> getSongs() throws FileNotFoundException {
        init();
        Comparator<Song> comparator = Comparator.comparing(Song::getName).thenComparing(Song::getArtist);
        List<Song> sorted = songList.stream().sorted(comparator).collect(Collectors.toList());
        return new ArrayList<Song>(sorted);
    }
    public Song getSong(String id) throws FileNotFoundException {
        init();
        List<Song> filtered = songList.stream().filter(song -> song.getId().equals(id)).collect(Collectors.toList());
        if (filtered.isEmpty()) {
            throw new NoSuchElementException("The requested song does not exist.");
        }
        return filtered.get(0);
    }
    public void createSong(Song song) throws FileNotFoundException {
        init();
        // make sure the song being added is not a duplicate
        List<Song> duplicateSongFilter = songList.stream()
                .filter(s -> s.getArtist().equalsIgnoreCase(song.getArtist()) && s.getName().equalsIgnoreCase(song.getName()))
                .collect(Collectors.toList());
        if (!duplicateSongFilter.isEmpty()) {
            throw new IllegalArgumentException("A song already exists with the same name and artist.");
        }
        songList.add(song);
        // write the update list to file
        Gson gson = new Gson();
        try {
            Writer writer = new FileWriter("./storage.json");
            gson.toJson(songList, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteSong(String id) throws FileNotFoundException {
        init();
        // make sure the song to delete exits
        List<Song> songToDeleteFilter = songList.stream().filter(song -> song.getId().equals(id)).collect(Collectors.toList());
        if (songToDeleteFilter.isEmpty()) {
            throw new NoSuchElementException("The song to delete does not exist.");
        }
        List<Song> filtered = songList.stream().filter(song -> !song.getId().equals(id)).collect(Collectors.toList());
        // write the updated list to file
        Gson gson = new Gson();
        try {
            Writer writer = new FileWriter("./storage.json");
            gson.toJson(filtered, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateSong(String id, String name, String artist, String album, String year) throws FileNotFoundException {
        init();
        // check that the song to update exists
        List<Song> songToEditFilter = songList.stream().filter(song -> song.getId().equals(id)).collect(Collectors.toList());
        if (songToEditFilter.isEmpty()) {
            throw new NoSuchElementException("The song to update does not exist.");
        }
        // make sure that the song is not a duplicate, negating id match to allow for idempotence
        List<Song> duplicateSongFilter = songList.stream()
                .filter(song -> song.getArtist().equalsIgnoreCase(artist) && song.getName().equalsIgnoreCase(name) && !song.getId().equals(id))
                .collect(Collectors.toList());
        if (!duplicateSongFilter.isEmpty()) {
            throw new IllegalArgumentException("A song already exists with the same name and artist.");
        }
        // get the song to edit
        Song song = songToEditFilter.get(0);

        // update the song
        song.setName(name);
        song.setArtist(artist);
        song.setAlbum(album);
        song.setYear(year);

        // write the update list to file
        Gson gson = new Gson();
        try {
            Writer writer = new FileWriter("./storage.json");
            gson.toJson(songList, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
