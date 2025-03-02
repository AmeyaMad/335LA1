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

//      TODO DELETE AT END IF NEVER USED
//    this was never used, but keeping in case needed
//    public Rating getStars() {
//        return stars;
//    }

    //this function allows us to set the stars for a song while keeping encapsulation
    //@pre stars != null
    public void setStars(Rating stars) {
        this.stars = stars;
    }

    //overriding the toString to make printing easier
    @Override
    public String toString() {
        return "Song - Title: " + title + ", Artist: " + artist + ", Album: " + album;
    }


    //Overriding the equals function to make .contains for an arrayList work
    //@pre o != null && o.getClass() == this.getClass()
    //I think by doing this we dont need the top part of the code, and dont need to test it
    @Override
    public boolean equals(Object o) {

//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
        Song song = (Song) o;
        return this.title != null && this.title.equals(song.title) && this.artist != null
                && this.artist.equals(song.artist) && this.album != null && this.album.equals(song.album);

    }

     //not sure if this is needed, will check later but when I looked online for why things are not removing it said
    //equals and hashcode may need to be overwritten, equals is already done if itm keeps being an issue
    //TODO uncomment this if needed later on
//    @Override
//    public int hashCode() {
//        return Objects.hash(title, artist, album); // Include all fields used in equals()
//    }

}
