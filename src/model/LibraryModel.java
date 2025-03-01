//file: LibraryModel.java
// Author: Ameya Madhugiri
// Purpose: The purpose of this class is to represent a users library of music, it is similar to the MusicStore, except
//          what is contained in there is defined by the user

package src.model;

import java.util.ArrayList;
import java.util.HashMap;

public class LibraryModel {
    // Setting up Instance Variables... will be similar to MusicStore
    // using hashmpas so it is easy to lookup
    // using arraylist as there could be multiple songs with the same title
    private HashMap<String, ArrayList<Song>> songsByTitle;

    // using arraylist as there could be multiple songs by the same artist
    private HashMap<String, ArrayList<Song>> songsByArtist;

    // using arraylist as there could be multiple albums with the same title
    private HashMap<String, ArrayList<Album>> albumsByTitle;

    // using arraylist as there could be multiple albums by the same artist
    private HashMap<String, ArrayList<Album>> albumsByArtist;

    // need to add a hashmap for playlists
    private HashMap<String, ArrayList<Song>> playlistByName;

    private MusicStore musicStore;

    private ArrayList<Song> favoriteSongs;

    private HashMap<Rating, ArrayList<Song>> songsByRating;

    // constructor will create an empty LibraryModel
    public LibraryModel(MusicStore musicStore) {
        songsByTitle = new HashMap<>();
        songsByArtist = new HashMap<>();
        albumsByTitle = new HashMap<>();
        albumsByArtist = new HashMap<>();
        playlistByName = new HashMap<>();
        this.musicStore = musicStore;
        favoriteSongs = new ArrayList<Song>();
        songsByRating = new HashMap<>();
    }

    // using the same logic and code from the MusicStore class for searching

    // now making getter functions for all the maps

    // gets song by title
    public ArrayList<Song> getSongsByTitle(String title) {
        if (songsByTitle.containsKey(title)) {
            return new ArrayList<Song>(songsByTitle.get(title));
        } else {
            return null;
        }
    }

    // gets song by artist
    public ArrayList<Song> getSongsByArtist(String artist) {
        if (songsByArtist.containsKey(artist)) {
            return new ArrayList<Song>(songsByArtist.get(artist));
        } else {
            return null;
        }

    }

    // gets albums by title
    public ArrayList<Album> getAlbumsByTitle(String title) {
        if (albumsByTitle.containsKey(title)) {
            return new ArrayList<Album>(albumsByTitle.get(title));
        } else {
            return null;
        }
    }

    // gets albums by artist
    public ArrayList<Album> getAlbumsByArtist(String artist) {
        if (albumsByArtist.containsKey(artist)) {
            return new ArrayList<Album>(albumsByArtist.get(artist));
        } else {
            return null;
        }
    }

    // adding in playlist function
    public ArrayList<Song> getPlaylistByName(String name) {
        if (!playlistByName.containsKey(name)) {
            return null;
        }
        return playlistByName.get(name);
    }

    // making a functions that returns string in a clean format bc default
    // ArrayList.toString() stinks!

    // string for songs by title
    public String getSongsByTitleString(String title) {
        if (getSongsByTitle(title) == null) {
            return "This Song is not in the songs list\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Song s : getSongsByTitle(title)) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }

    // string for songs by artist
    public String getSongsByArtistString(String artist) {
        if (getSongsByArtist(artist) == null) {
            return "There are no songs by this artist\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Song s : getSongsByArtist(artist)) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }

    // string for albums by title
    public String getAlbumsByTitleString(String title) {
        if (getAlbumsByTitle(title) == null) {
            return "There are no albums of this name\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Album a : getAlbumsByTitle(title)) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    // string for albums by artist
    public String getAlbumsByArtistString(String artist) {
        if (getAlbumsByArtist(artist) == null) {
            return "There are no albums by this artist\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Album a : getAlbumsByArtist(artist)) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    // adding in playlist function for string
    public String getPlaylistByNameString(String title) {
        if (getPlaylistByName(title) == null) {
            return "There are no playlists by this title\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Song s : getPlaylistByName(title)) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }

    // now we need new logic for adding and removing songs/albums
    // @pre title != null
    public String addSongToLibrary(String title, String artist) {
        Song sWeWant = HelperFunctions.getSongByTitleAndArtist(title, artist);

        if (sWeWant == null) {
            return "This song is not in the Music Store\n";
        }

        if (songsByTitle.containsKey(title)) {
            for (Song s : songsByTitle.get(title)) {
                if (s.getArtist().equals(artist)) {
                    return "This song is already in the list\n";
                }
            }
            songsByTitle.get(title).add(sWeWant);
        } else {
            ArrayList<Song> newSongs = new ArrayList<Song>();
            newSongs.add(sWeWant);
            songsByTitle.put(title, newSongs);
        }

        if (songsByArtist.containsKey(artist)) {
            songsByArtist.get(artist).add(sWeWant);
        } else {
            ArrayList<Song> tmp = new ArrayList<>();
            tmp.add(sWeWant);
            songsByArtist.put(artist, tmp);
        }
        return "Successfully added song to the library\n";
    }

    // Logic for adding albums to library
    // @pre title != null
    public boolean addAlbumToLibrary(String title) {
        ArrayList<Album> albums = musicStore.getAlbumsByTitle(title);
        if (albums == null) {
            return false; // album is not found in musicStore
        }

        Album a = albums.get(0); // since there is only 1 album of each name

        if (albumsByTitle.containsKey(title)) {
            return false; // Album is already in the library
        }

        // Add album by title
        albumsByTitle.put(title, albums);

        // Add album to artist-based lookup
        if (albumsByArtist.containsKey(a.getArtist())) {
            albumsByArtist.get(a.getArtist()).add(a);
        } else {
            albumsByArtist.put(a.getArtist(), albums);
        }
        return true;
    }

    // this will be used to add songs to favorite
    // @pre title != null && artist != null
    public String addSongToFavorites(String title, String artist) {
        // using helper function
        Song sWeWant = HelperFunctions.getSongByTitleAndArtist(title, artist);
        if (sWeWant == null) {
            return "There is no song with this name and by this Artist\n";
        }



        // making sure it is not already on our list
        if (favoriteSongs.contains(sWeWant)) {
            return "This song is already in the favorites list\n";
        } else {
            favoriteSongs.add(sWeWant);
        }

        // set rating to 5 if it is not already
        if (songsByRating.containsKey(Rating.FIVE) && songsByRating.get(Rating.FIVE).contains(sWeWant)) {
            return "This song is already rated 5 and in the favorites list.\n";
        }

        rateSong(title, artist, Rating.FIVE);
        // if it hasnt returned by now we know it worked
        return "Successfully added song to the favorites list\n";
    }

    public ArrayList<Song> getFavorites() {
        if (favoriteSongs.isEmpty()) {
            return null;
        } else {
            return new ArrayList<>(favoriteSongs);
        }
    }

    public String getFavoritesString() {
        if(getFavorites() == null){
            return "There are no favorites\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Song s : favoriteSongs) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }



    // this function will take in details of a song and set its rating,
    // if the rating is 5 it will automatically get placed into the favorites
    // @pre title != null && artist != null && rating != null
    public String rateSong(String title, String artist, Rating rating) {
        Song sWeWant = HelperFunctions.getSongByTitleAndArtist(title, artist);
        if (sWeWant == null) {
            return "There is no song that has this name by this artist\n";
        }
        // first set the rating to input
        sWeWant.setStars(rating);



        // now add to our songs by rating hashmap
        if (songsByRating.containsKey(rating)) {
            songsByRating.get(rating).add(new Song(sWeWant)); // to keep encapsulation
        } else {
            ArrayList<Song> tmp = new ArrayList<>();
            tmp.add(new Song(sWeWant));
            songsByRating.put(rating, tmp); // create a new arraylist with new song obj to add to HashMap
        }

        // if rating == five automatically place in fav
        if (rating == Rating.FIVE && !favoriteSongs.contains(sWeWant)) {
            addSongToFavorites(title, artist);
        }
        return "Successfully rated song\n";
    }

    // This function i dont think is required by the spec but makes sense if setting
    // ratings
    // @pre r != null
    public ArrayList<Song> getSongsByRating(Rating r) {
        if (songsByRating.containsKey(r)) {
            return new ArrayList<Song>(songsByRating.get(r));
        } else {
            return null;
        }
    }

    public String getSongsByRatingString(Rating r) {
        if(getSongsByRating(r)==null) {
            return "There are no songs of this rating\n";
        }
        ArrayList<Song> songs = songsByRating.get(r);
        StringBuilder sb = new StringBuilder();
        for (Song s : songs) {
            sb.append(s.toString() + "\n");
        }
        return sb.toString();
    }

}
