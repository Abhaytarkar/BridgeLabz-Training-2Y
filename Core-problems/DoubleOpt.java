import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read double values for a, b, and c
        System.out.print("Enter value for a (e.g., fee): ");
        double a = scanner.nextDouble();

        System.out.print("Enter value for b (e.g., discountPercent): ");
        double b = scanner.nextDouble();

        System.out.print("Enter value for c: ");
        double c = scanner.nextDouble();

        // Double operations with precedence
        double result1 = a + b * c;       // Multiplication before addition
        double result2 = a * b + c;       // Multiplication before addition
        double result3 = c + a / b;       // Division before addition
        double result4 = a % b + c;       // Modulus before addition

        // Output: Display the results
        System.out.println("The results of Double Operations are:");
        System.out.printf("a + b * c = %.2f\n", result1);
        System.out.printf("a * b + c = %.2f\n", result2);
        System.out.printf("c + a / b = %.2f\n", result3);
        System.out.printf("a %% b + c = %.2f\n", result4); // %% to escape the % symbol

        scanner.close();
    }
}
