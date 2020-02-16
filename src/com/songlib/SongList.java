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
        List<Song> filtered = songList.stream().filter(song -> song.getId() == id).collect(Collectors.toList());
        if (filtered.isEmpty()) {
            throw new NoSuchElementException();
        }
        return filtered.get(0);
    }
    public void createSong(Song song) throws FileNotFoundException {
        init();
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
        List<Song> filtered = songList.stream().filter(song -> song.getId() != id).collect(Collectors.toList());
        // write the update list to file
        Gson gson = new Gson();
        try {
            Writer writer = new FileWriter("./storage.json");
            gson.toJson(filtered, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateSong(String id, String name, String artist, String album, String year) throws FileNotFoundException {
        init();
        List<Song> filtered = songList.stream().filter(song -> song.getId() == id).collect(Collectors.toList());
        if (filtered.isEmpty()) {
            throw new NoSuchElementException();
        }
        Song song = songList.get(0);
        song.setName(name);
        song.setArtist(name);
        song.setAlbum(name);
        song.setYear(name);
        // write the update list to file
        Gson gson = new Gson();
        try {
            Writer writer = new FileWriter("./storage.json");
            gson.toJson(songList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
