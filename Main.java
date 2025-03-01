import src.model.*;
import src.view.*;

public class Main {
    public static void main(String[] args) {
        // Initializing the MusicStore with all songs from album dir
        MusicStore musicStore = new MusicStore("albums");

        LibraryModel lb = new LibraryModel(musicStore);
        lb.addSongToLibrary("Lullaby", "Leopard Cohen");
        lb.addSongToLibrary("Lullaby", "OneRepublic");
        // TODO implement view stuff here instead of just testing

        // TODO WE NEED TO MAKE SURE THERE IS NO INFINITELOOP WHEN DOING FAVORITES AND
        // SETTING RATINGS
        lb.addSongToFavorites("You Ain't Alone", "Alabama Shakes");
        System.out.print(lb.getFavorites());
    }
}
