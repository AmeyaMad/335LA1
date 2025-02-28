package test.modelTest;

import org.junit.Test;
import src.model.Song;

import static org.junit.Assert.*;

public class SongTest {
    Song song = new Song("Rolling in the Deep", "Adele", "21");
    Song song2 = new Song(song);

    @Test
    public void testGetTitle() {
        assertEquals("Rolling in the Deep", song.getTitle());
    }

    @Test
    public void testGetArtist() {
        assertEquals("Adele", song.getArtist());
    }

    @Test
    public void testGetAlbum() {
        assertEquals("21", song.getAlbum());
    }

    @Test
    public void testToString() {
        assertEquals("Song - Title: Rolling in the Deep, Artist: Adele, Album: 21\n", song.toString());
    }
}
