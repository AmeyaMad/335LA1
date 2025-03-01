package test.modelTest;

import src.model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryModelTest {
    MusicStore musicStore = new MusicStore("albums");
    LibraryModel libraryModel = new LibraryModel(musicStore);

    @Test
    public void testAddandGetSongToLibrary() {
        libraryModel.addSongToLibrary("Daylight", "Coldplay");
        assertEquals("Song - Title: Daylight, Artist: Coldplay, Album: A Rush of Blood to the Head\n",
                libraryModel.getSongsByTitleString("Daylight"));
    }

    @Test
    public void testBadInputGetSongFromLibrary() {
        libraryModel.addSongToLibrary("Daylight", "Coldplay");
        assertEquals("This Song is not in the songs list\n",
                libraryModel.getSongsByTitleString("BLAH"));
    }

    @Test
    public void testAddSongToLibraryWhenNotInStore() {
        assertFalse(libraryModel.addSongToLibrary("YELLOWBRICKROAD", "IDK"));
    }

    @Test
    // this will be for the 2 lulabys
    public void testAddingTwoSongsSameName() {
        libraryModel.addSongToLibrary("Lullaby", "Leonard Cohen");
        libraryModel.addSongToLibrary("Lullaby", "OneRepublic");

        String ex = "Song - Title: Lullaby, Artist: Leonard Cohen, Album: Old Ideas\n" +
                "Song - Title: Lullaby, Artist: OneRepublic, Album: Waking Up\n";
        assertEquals(ex, libraryModel.getSongsByTitleString("Lullaby"));
    }

    @Test
    // this will be for adding 2 of the same song
    public void testAddingSameSong2Times() {
        libraryModel.addSongToLibrary("Lullaby", "Leonard Cohen");
        assertFalse(libraryModel.addSongToLibrary("Lullaby", "Leonard Cohen"));
    }

    @Test
    public void testAddingSongRightNameWrongArtist() {
        assertFalse(libraryModel.addSongToLibrary("After Party", "Adele"));
    }

    @Test
    public void testGetSongsByArtist() {
        libraryModel.addSongToLibrary("I'll Be Waiting", "Adele");
        libraryModel.addSongToLibrary("I Found a Boy", "Adele");
        libraryModel.addSongToLibrary("First Love", "Adele");

        String ex = "Song - Title: I'll Be Waiting, Artist: Adele, Album: 21\n" +
                "Song - Title: I Found a Boy, Artist: Adele, Album: 21\n" +
                "Song - Title: First Love, Artist: Adele, Album: 19\n";
        assertEquals(ex, libraryModel.getSongsByArtistString("Adele"));
    }

    @Test
    public void testGetSongsByArtistEmpty() {
        libraryModel.addSongToLibrary("First Love", "Adele");
        assertEquals("There are no songs by this artist\n", libraryModel.getSongsByArtistString("Kanye"));
    }

    @Test
    public void testGetAlbumsByName() {
        libraryModel.addAlbumToLibrary("Begin Again");
        String ex = "Album: Begin Again, Artist: Norah Jones, Genre: Pop\n" +
                "My Heart Is Full\n" +
                "Begin Again\n" +
                "It Was You\n" +
                "A Song with No Name\n" +
                "Uh Oh\n" +
                "Wintertime\n" +
                "Just a Little Bit\n" +
                "\n";
        assertEquals(ex, libraryModel.getAlbumsByTitleString("Begin Again"));
    }

    @Test
    public void testGetAlbumsByNameEmpty(){
        assertEquals("There are no albums of this name\n", libraryModel.getAlbumsByTitleString("na"));
    }

    @Test
    public void testGetAlbumsByArtist() {
        libraryModel.addAlbumToLibrary("19");
        libraryModel.addAlbumToLibrary("21");
        String ex = "Album: 19, Artist: Adele, Genre: Pop\n" +
                "Daydreamer\n" +
                "Best for Last\n" +
                "Chasing Pavements\n" +
                "Cold Shoulder\n" +
                "Crazy for You\n" +
                "Melt My Heart to Stone\n" +
                "First Love\n" +
                "Right as Rain\n" +
                "Make You Feel My Love\n" +
                "My Same\n" +
                "Tired\n" +
                "Hometown Glory\n" +
                "\n" +
                "Album: 21, Artist: Adele, Genre: Pop\n" +
                "Rolling in the Deep\n" +
                "Rumour Has It\n" +
                "Turning Tables\n" +
                "Don't You Remember\n" +
                "Set Fire to the Rain\n" +
                "He Won't Go\n" +
                "Take It All\n" +
                "I'll Be Waiting\n" +
                "One and Only\n" +
                "Lovesong\n" +
                "Someone Like You\n" +
                "I Found a Boy\n" +
                "\n";
        assertEquals(ex, libraryModel.getAlbumsByArtistString("Adele"));
    }

    @Test
    public void testGetAlbumsByArtistEmpty() {
       assertEquals("There are no albums by this artist\n", libraryModel.getAlbumsByArtistString("na"));
    }

    @Test
    public void testAddingAlbumNotInLib(){
        assertFalse(libraryModel.addAlbumToLibrary("Graduation"));
    }

    @Test
    public void testAddingSameAlbum2times(){
        libraryModel.addAlbumToLibrary("Fight for Your Mind");
        assertFalse(libraryModel.addAlbumToLibrary("Fight for Your Mind"));
    }

}
