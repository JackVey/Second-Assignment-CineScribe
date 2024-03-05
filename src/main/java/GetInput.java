import java.util.Scanner;

public class GetInput {
    static Scanner in = new Scanner(System.in);
    static int returnIntInput() {
        try {
            Color.ChangeTextOrBackgroundColor(Color.PURPLE_BRIGHT);
            System.out.print("Input: ");
            Color.ChangeTextOrBackgroundColor(Color.GREEN);
            return in.nextInt();
        }
        catch (Exception e){
            return 0;
        }
    }

    static String returnStringInput(){
        try {
            Color.ChangeTextOrBackgroundColor(Color.PURPLE_BRIGHT);
            System.out.print("Input: ");
            Color.ChangeTextOrBackgroundColor(Color.GREEN);
            return in.nextLine();
        }
        catch (Exception e){
            return null;
        }
    }
}