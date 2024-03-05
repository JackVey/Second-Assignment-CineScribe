import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
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
        Color.ChangeTextOrBackgroundColor(Color.CYAN_BRIGHT);
        System.out.print("Input a title to search or type BACK to return to main menu\n");
        String input = GetInput.returnStringInput();
        if (input.equals("BACK")){
            clearPage();
            displayMainMenu();
        }
        else{
            Movie movie = new Movie(new ArrayList<>(), "",0);
            displayMovieResult(movie.getMovieData(input));
        }
    }

    static void displayErrorPage(){

    }

    static void clearPage(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static void displayMovieResult(String res){

    }

}
