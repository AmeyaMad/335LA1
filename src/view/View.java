//file: View.java
//Author: Ameya Madhugiri & chatGPT
//purpose: This is the file used to accsess everything I hvae done before this
//it will allow the user to interact with both the Music Store and the User lib
//I will be heavily utilizing AI specifically chatGPT for this portion of the project
package src.view;
import java.util.Scanner;

/// UNDER HERE IT IS ALMOST ALL AI GEN, WILL ADD MY OWN COMMENTS AS WELL

/*
 * View.java
 *
 * This class provides a simple text-based UI for interacting with the music system.
 * The user can navigate between the Music Store and User Library menus, search for songs/albums,
 * manage playlists, rate songs, and more.
 */
public class View {
    private Scanner scanner; // Scanner object to handle user input

    /*
     * Constructor for the View class.
     * Initializes the scanner for reading user input.
     */
    public View() {
        scanner = new Scanner(System.in);
    }

    /*
     * Starts the main menu loop, allowing the user to navigate the system.
     */
    public void start() {
        while (true) {
            // Display main menu options
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Access Music Store");
            System.out.println("2. Access User Library");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidIntInput(); // Get valid integer input from user

            // Handle user selection
            switch (choice) {
                case 1:
                    showMusicStoreMenu();
                    break;
                case 2:
                    showUserLibraryMenu();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }

    /*
     * Ensures the user inputs a valid integer.
     * If the input is not an integer, it will prompt the user until a valid input is received.
     *
     * @return A valid integer entered by the user.
     */
    private int getValidIntInput() {
        while (!scanner.hasNextInt()) { // Check if input is a valid integer
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt(); // Return valid integer input
    }


    /// THIS SECTION DEALS WITH OTHER VIEWS, ABOVE IS MAIN MENU AND BELOW IS
    /*
     * Displays the Music Store Menu.
     * The user will be able to search for songs/albums in the store.
     * (Functionality to be implemented in the next step)
     */
    private void showMusicStoreMenu() {
        System.out.println("\n[Music Store Menu Placeholder]");
        // This will be implemented in the next steps
    }

    /*
     * Displays the User Library Menu.
     * The user will be able to manage their personal music library, playlists, favorites, etc.
     * (Functionality to be implemented in the next step)
     */
    private void showUserLibraryMenu() {
        System.out.println("\n[User Library Menu Placeholder]");
        // This will be implemented in the next steps
    }
}




