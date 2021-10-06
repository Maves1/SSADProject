import java.util.Scanner;

public class Platform {
    static Scanner scanner = new Scanner(System.in);
    public static boolean checkIfLegal() {
        int userInput = scanner.nextInt();
        while (userInput != 0 && userInput != 1) {
            System.out.println("Please enter a correct number!");
            System.out.println("Are you over 18?\n1 - Yes\n2 0 No");
            userInput = scanner.nextInt();
        }
        if (userInput == 1) {
            return true;
        } else {
            return false;
        }
    }
}
