//file: LibraryModel.java
// Author: Ameya Madhugiri
// Purpose: The purpose of this class is to represent a users library of music, it is similar to the MusicStore, except
//          what is contained in there is defined by the user

package src.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
}
