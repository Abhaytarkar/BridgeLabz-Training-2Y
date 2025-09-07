import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        String feedback;
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            feedback = sc.nextLine();

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Yay! Guessed it right.");
                break;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            }
        }
        sc.close();
    }

    static int generateGuess(int low, int high) {
        return new Random().nextInt(high - low + 1) + low;
    }
}