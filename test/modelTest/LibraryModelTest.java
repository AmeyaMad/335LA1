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
}
