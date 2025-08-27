import java.util.Scanner;

public class SquareSideCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read perimeter from the user
        System.out.print("Enter the perimeter of the square (in cm): ");
        double perimeter = scanner.nextDouble();

        // Calculate side length
        double side = perimeter / 4;

        // Output: Display the result
        System.out.printf("The length of the side is %.2f cm whose perimeter is %.2f cm\n", side, perimeter);

        scanner.close();
    }
}
