import java.util.Scanner;

public class DivisionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read two numbers from the user
        System.out.print("Enter the first number (dividend): ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number (divisor): ");
        int number2 = scanner.nextInt();

        // Check for division by zero
        if (number2 == 0) {
            System.out.println("Error: Division by zero is not allowed.");
        } else {
            // Calculate quotient and remainder
            int quotient = number1 / number2;
            int remainder = number1 % number2;

            // Output: Display the results
            System.out.printf("The Quotient is %d and Remainder is %d of two numbers %d and %d\n",
                              quotient, remainder, number1, number2);
        }

        scanner.close();
    }
}
