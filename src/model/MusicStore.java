//  file: MusicStore.java
//  Author: Ameya Madhugiri
//  Purpose: The purpose of this class is to be a sort of global library of all known songs
//              (all songs input in albums folder) that we can pull from
package src.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class MusicStore {
    //Setting up instance variables (will only create one MusicStore obj however)

    //using arraylist as there could be multiple albums with the same title
    private Map<String, ArrayList<Album>> albums;

    //using arraylist as there could be multiple songs with the same title
    private Map<String, ArrayList<Song>> songsByTitle;

    //using arraylist as there could be multiple songs by the same artist
    private Map<String, ArrayList<Song>> songsByArtist;


    //constructor to create MusicStore that takes in the name of a directory and creates a map
    public MusicStore(String dirName){
        File dir = new File(dirName);
        //TODO get rid, just make sure it is reading correctly
        File[] files = dir.listFiles();
        for(int i = 0; i < files.length; i++){
            System.out.println(files[i].getName());
        }

        //TODO IMPLEMENT HERE
    }



}
