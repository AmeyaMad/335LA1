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

    // constructor will create an empty LibraryModel
    public LibraryModel(MusicStore musicStore) {
        songsByTitle = new HashMap<>();
        songsByArtist = new HashMap<>();
        albumsByTitle = new HashMap<>();
        albumsByArtist = new HashMap<>();
        playlistByName = new HashMap<>();
        this.musicStore = musicStore;
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
    public boolean addSongToLibrary(String title, String artist) {
        if (musicStore.getSongsByTitle(title) == null) {
            return false;
        }
        ArrayList<Song> songs = musicStore.getSongsByTitle(title);
        Song sWeWant = null;
        for (Song s : songs) {
            if (s.getArtist().equals(artist)) {
                sWeWant = s;
            }
        }

        if (sWeWant == null) {
            return false;
        }

        if (songsByTitle.containsKey(title)) {
            for (Song s : songsByTitle.get(title)) {
                if (s.getArtist().equals(artist)) {
                    return false; // this song is already in the list
                }
            }
            songsByTitle.get(title).add(sWeWant);
        } else {
            ArrayList<Song> newSongs = new ArrayList<Song>();
            newSongs.add(sWeWant);
            songsByTitle.put(title, newSongs);
        }
        return true;
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
        if (albumsByArtist.containsKey(title)) {
            albumsByArtist.get(a.getArtist()).add(a);
        } else {
            albumsByArtist.put(a.getArtist(), albums);
        }
        return true;
    }

}
