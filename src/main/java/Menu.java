import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu{

    static void displayMainMenu() throws IOException {
        clearPage();
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
    static void displayActorsSearchMenu() throws IOException {
        clearPage();
        Color.ChangeTextOrBackgroundColor(Color.GREEN);
        System.out.print("~~~~~~~~~~~~~~~~~ ");
        Color.ChangeTextOrBackgroundColor(Color.RED_BOLD);
        System.out.print("Actor search menu");
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
            Actors actor = new Actors("", true);
            displayActorResult(actor.getActorData(input));
            displayActorsSearchMenu();
        }
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
            displayMoviesSearchMenu();
        }
    }
    static void clearPage(){
        System.out.print("\033\143");
        System.out.flush();
        //ANSI code to clear buffer
        System.out.print("\u001B[K");
    }
    static void displayMovieResult(String res) throws IOException {
        clearPage();
        try {
            Movie movie = new Movie(new ArrayList<>(), "",0);
            ArrayList<String> actorsList = movie.getActorListViaApi(res);
            JSONObject json = new JSONObject(res);
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                if (key.equals("Ratings")) {
                    System.out.println(Color.GREEN_BOLD_BRIGHT + "Ratings:");
                    for (Object i : json.getJSONArray("Ratings")) {
                        Color.ChangeTextOrBackgroundColor(Color.RED_BOLD_BRIGHT);
                        System.out.println("Source: " + Color.YELLOW_BRIGHT + ((JSONObject) i).getString("Source"));
                        System.out.println("Value: " + Color.YELLOW_BRIGHT + ((JSONObject) i).getString("Value"));
                    }
                    continue;
                }
                if (key.equals("Response"))
                    continue;
                Color.ChangeTextOrBackgroundColor(Color.GREEN_BOLD_BRIGHT);
                System.out.println(key + ": " + Color.RED + json.getString(key));
            }
            System.out.println("Press enter to continue or select an actor to lookup");
            int i = 1;
            for (String j : actorsList){
                System.out.println(Color.CYAN_BRIGHT + i +"- " + Color.GREEN_BRIGHT + j);
                i++;
            }
            String input = GetInput.returnStringInput();
            for (int j = 0; j < input.length(); j++) {
                if (!Character.isDigit(input.charAt(j))) {
                    clearPage();
                    return;
                }
            }
            if (Integer.parseInt(input) <= i){
                Actors actor = new Actors("", true);
                displayActorResult(actor.getActorData(actorsList.get(Integer.parseInt(input))));
            }
            clearPage();
        }
        catch (Exception e){
            displayMoviesSearchMenu();
        }
    }
    static void displayActorResult(String res) throws IOException {
        try {
            clearPage();
            JSONObject json = new JSONObject(res.substring(1, res.length() - 1));
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                if (key.equals("occupation")) {
                    System.out.println(Color.GREEN_BOLD_BRIGHT + "Occupation:");
                    for (Object i : json.getJSONArray("occupation")) {
                        Color.ChangeTextOrBackgroundColor(Color.RED_BOLD_BRIGHT);
                        System.out.println(i);
                    }
                    continue;
                }
                Color.ChangeTextOrBackgroundColor(Color.GREEN_BOLD_BRIGHT);
                System.out.println(key + ": " + Color.RED + json.get(key.toString()));
            }
            System.out.println("Press enter to continue...");
            GetInput.returnStringInput();
            clearPage();
        }
        catch (Exception e){
            displayActorsSearchMenu();
        }
    }

}
