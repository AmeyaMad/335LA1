// file: Song.java
// author: Ameya Madhugiri
// purpose: This class is going to represent a song, and will hold information about it
//          this class will also be immutable since we dont want to change details
package src.model;

public class Song {
    // setting up instance variables to hold information about the song
    // could be final but not needed since strings are already immutable
    private String title;
    private String artist;
    private String album;
    private Rating stars;

    /*
     * constructor so we can create song objects easily
     * 
     * @pre title != null && artist != null && album != null
     */
    public Song(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    /*
     * constructor to make making copies a lot easier
     * 
     * @pre s != null
     */
    public Song(Song s) {
        this.title = s.title;
        this.artist = s.artist;
        this.album = s.album;
    }

    // auto generated getters for each
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public Rating getStars() {
        return stars;
    }

    public void setStars(Rating stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Song - Title: " + title + ", Artist: " + artist + ", Album: " + album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Song song = (Song) o;
        return this.title != null && this.title.equals(song.title) && this.artist != null
                && this.artist.equals(song.artist) && this.album != null && this.album.equals(song.album);

    }
}
