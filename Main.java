import src.model.*;
import src.view.*;
public class Main {
    public static void main(String[] args) {
        //Initializing the MusicStore with all songs from album dir
        MusicStore musicStore = new MusicStore("albums");

        //TODO implement view stuff here instead of just testing
        System.out.print(musicStore.getAlbumsByArtistString("Coldplay"));
    }
}
