//  file: PlayList.java
//  Author: Ameya Madhugiri
//  Purpose: The purpose of this class is to represent a user defined playlist, with a name and songs
package src.model;

import java.util.ArrayList;

public class PlayList {
    //setting up instance variables
    private String name;
    private ArrayList<Song> songs;

    /*
     Constructor to make the creation of a playlist easier if list already exists

     @pre name != null
     */
    public PlayList(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = new ArrayList<>(songs);
    }

    /*
        Constructor if we want an empty playlist

        @pre title != null
    */

    public PlayList(String name) {
        this.name = name;
    }

    //auto gen getter for name
    public String getName() {
        return name;
    }

    // Methods to modify playlist
    //TODO: COMMENT THESE AND ADD MORE METHODS
    public void addSong(Song s){
        songs.add(new Song(s));
    }

    public void removeSong(Song s){
        songs.remove(s);
    }

}

