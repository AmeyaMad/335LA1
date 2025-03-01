package src.model;

import java.util.ArrayList;

public class HelperFunctions {
    // This looks like what I found online in terms of how to set up a class to be
    // used like Math.abs() or similar
    // I remember it was brought up in class but was not able to find any reference
    // to it

    // private constructor to prevent instantiation
    private HelperFunctions() {
    }

    public static Song getSongByTitleAndArtist(String title, String artist) {
        // making a music store
        MusicStore ms = new MusicStore("albums");
        // if we are unable to find any songs with that name, return null
        if (ms.getSongsByTitle(title) == null) {
            return null;
        }

        // list of all songs with the name
        ArrayList<Song> songsWithName = ms.getSongsByTitle(title);

        // setting up return obj
        Song sWeWant = null;
        // check each song in the list for the one with the right artist
        for (Song s : songsWithName) {
            if (s.getArtist().equals(artist)) {
                sWeWant = s;
            }
        }
        if (sWeWant == null) {
            return null;
        }
        // return result, if not able to find one still return null
        return new Song(sWeWant);
    }

}
