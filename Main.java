import src.model.*;
import src.view.*;
public class Main {
    public static void main(String[] args) {
        MusicStore test = new MusicStore("albums");


        System.out.println(test.getSongsByTitle("Lullaby"));
    }
}
