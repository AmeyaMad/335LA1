package test.modelTest;

import org.junit.Test;
import src.model.*;

import static org.junit.Assert.assertEquals;


public class PlayListTest {
    PlayList pl = new PlayList("RandomPlayList");
    Song hereWeGo = new Song("Here We Go", "Ozomatli", "Don't Mess With the Dragon");
    Song iAint = new Song("I Ain't the Same", "Alabama Shakes", "Boys & Girls");


    @Test
    public void testGetName() {
        assertEquals("RandomPlayList", pl.getName());
    }


    @Test
    public void testAddSong() {
        pl.addSong(hereWeGo);
        pl.addSong(iAint);
        String ex = "Title: Here We Go, Artist: Ozomatli, Album: Don't Mess With the Dragon\n" +
                "Title: I Ain't the Same, Artist: Alabama Shakes, Album: Boys & Girls\n";
        assertEquals(ex, pl.getSongsString());
    }


    @Test
    public void testRemoveSong() {
        pl.addSong(hereWeGo);
        pl.addSong(iAint);
        pl.removeSong(hereWeGo);
        String ex = "Title: I Ain't the Same, Artist: Alabama Shakes, Album: Boys & Girls\n";
        assertEquals(ex, pl.getSongsString());
        //System.out.print(pl.getSongsString());
    }

    @Test
    public void addingSameSong(){
        pl.addSong(iAint);
        pl.addSong(iAint);
        String ex = "Title: I Ain't the Same, Artist: Alabama Shakes, Album: Boys & Girls\n";
        assertEquals(ex, pl.getSongsString());
    }

}
