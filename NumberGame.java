import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        while(true){
            int secretNumber = rd.nextInt(100)+1;
            int maxAttemps = 10;
            int attempts = 0;
            System.out.println("\nI have selected a number between 1 and 100. Try to guess it!");
            while(attempts < maxAttemps){
                System.out.println("Your guess");
                int userGuess = sc.nextInt();
                if(userGuess == secretNumber){
                    System.out.println("Congratulations! You guessed the correct number!");
                    break;
                } else if (userGuess<secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                attempts++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }

        }
        sc.close();
    }
}
