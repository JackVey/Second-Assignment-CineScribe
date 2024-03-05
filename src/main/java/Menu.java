import java.io.Console;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Menu{

    static void displayMainMenu() throws IOException {
        Color.ChangeTextOrBackgroundColor(Color.GREEN);
        System.out.print("~~~~~~~~~~~~~~~~~ ");
        Color.ChangeTextOrBackgroundColor(Color.RED_BOLD);
        System.out.print("Eclipse search v7.6");
        Color.ChangeTextOrBackgroundColor(Color.GREEN);
        System.out.print(" ~~~~~~~~~~~~~~~~~\n");
        Color.ChangeTextOrBackgroundColor(Color.YELLOW_BRIGHT);
        System.out.print("[1] ");
        Color.ChangeTextOrBackgroundColor(Color.CYAN_BRIGHT);
        System.out.print("Search for Movie\n");
        Color.ChangeTextOrBackgroundColor(Color.YELLOW_BRIGHT);
        System.out.print("[2] ");
        Color.ChangeTextOrBackgroundColor(Color.CYAN_BRIGHT);
        System.out.print("Search for Celebrity\n");
        Color.ChangeTextOrBackgroundColor(Color.YELLOW_BRIGHT);
        System.out.print("[3] ");
        Color.ChangeTextOrBackgroundColor(Color.CYAN_BRIGHT);
        System.out.print("Exit\n");

        switch (GetInput.returnIntInput()){
            case 1:
                displayMoviesSearchMenu();
                break;
            case 2:
                displayActorsSearchMenu();
                break;
            case 3:
                clearPage();
                Color.ChangeTextOrBackgroundColor(Color.RESET);
                System.exit(0);
                break;
            default:
                Color.ChangeTextOrBackgroundColor(Color.RED_BOLD_BRIGHT);
                System.out.print("Invalid input!");
                try{
                    TimeUnit.SECONDS.sleep(3);
                    clearPage();
                    displayMainMenu();
                }
                catch (Exception e){
                    clearPage();
                    displayMainMenu();
                }
                break;
        }
    }

    static void displayActorsSearchMenu(){

    }

    static void displayMoviesSearchMenu() throws IOException {
        clearPage();
        Color.ChangeTextOrBackgroundColor(Color.GREEN);
        System.out.print("~~~~~~~~~~~~~~~~~ ");
        Color.ChangeTextOrBackgroundColor(Color.RED_BOLD);
        System.out.print("Movie search menu");
        Color.ChangeTextOrBackgroundColor(Color.GREEN);
        System.out.print(" ~~~~~~~~~~~~~~~~~\n");
        Color.ChangeTextOrBackgroundColor(Color.YELLOW_BRIGHT);
        System.out.print("[1] ");
        Color.ChangeTextOrBackgroundColor(Color.CYAN_BRIGHT);
        System.out.print("Search by name\n");
        Color.ChangeTextOrBackgroundColor(Color.YELLOW_BRIGHT);
        System.out.print("[2] ");
        Color.ChangeTextOrBackgroundColor(Color.CYAN_BRIGHT);
        System.out.print("Search by IMDB ID\n");
        Color.ChangeTextOrBackgroundColor(Color.YELLOW_BRIGHT);
        System.out.print("[3] ");
        Color.ChangeTextOrBackgroundColor(Color.CYAN_BRIGHT);
        System.out.print("Back\n");
        switch (GetInput.returnIntInput()){
            case 1:
                Movie movie1 = new Movie(GetInput.returnStringInput(), "i");
                break;
            case 2:
                Movie movie2 = new Movie(GetInput.returnStringInput(), "t");
                break;
            case 3:
                clearPage();
                displayMainMenu();
                break;
            default:
                Color.ChangeTextOrBackgroundColor(Color.RED_BOLD_BRIGHT);
                System.out.print("Invalid input!");
                try{
                    TimeUnit.SECONDS.sleep(3);
                    clearPage();
                    displayMoviesSearchMenu();
                }
                catch (Exception e){
                    clearPage();
                    displayMoviesSearchMenu();
                }
                break;
        }
    }

    static void displayErrorPage(){

    }

    static void clearPage(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
