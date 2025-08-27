import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Get two floating-point numbers from the user
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        // Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        String division;

        // Handle division by zero
        if (number2 != 0) {
            division = String.valueOf(number1 / number2);
        } else {
            division = "undefined (division by zero)";
        }

        // Output: Display the results
        System.out.println("\nThe addition, subtraction, multiplication, and division value of 2 numbers " 
            + number1 + " and " + number2 + " is:");
        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);

        scanner.close();
    }
}
