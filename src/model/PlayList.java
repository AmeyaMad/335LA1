//  file: PlayList.java
//  Author: Ameya Madhugiri
//  Purpose: The purpose of this class is to represent a user defined playlist, with a name and songs
package src.model;

import java.util.ArrayList;

public class PlayList {
    // setting up instance variables
    private String name;
    private ArrayList<Song> songs;



    /*
     * Constructor if we want an empty playlist
     * 
     * @pre title != null
     */

    public PlayList(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    // auto gen getter for name
    public String getName() {
        return name;
    }

    //get an arraylist of all songs in list
    public ArrayList<Song> getSongs() {
        return new ArrayList<>(songs);
    }

    public String getSongsString(){
        ArrayList<Song> listOfSongs = this.getSongs();
        StringBuilder sb = new StringBuilder();
        for (Song song : listOfSongs) {
            sb.append("Title: ").append(song.getTitle())
                    .append(", Artist: ").append(song.getArtist())
                    .append(", Album: ").append(song.getAlbum())
                    .append("\n");
        }
        return sb.toString();
    }

    // Methods to modify playlist
    // TODO: COMMENT THESE AND ADD MORE METHODS
    //Adding songs to playlist
    //@pre s != null
    public void addSong(Song s) {
        if(!songs.contains(s)) {
            songs.add(new Song(s)); //keeping encapsulation
        }
    }

    //removing song from playlist
    //@pre s != null
    public void removeSong(Song s) {
        songs.remove(s);
    }

    public void addAlbum(String title) {
        this.name = name;
    }
}
