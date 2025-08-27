import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read values for a, b, and c
        System.out.print("Enter value for a (e.g., fee): ");
        int a = scanner.nextInt();

        System.out.print("Enter value for b (e.g., discountPercent): ");
        int b = scanner.nextInt();

        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();

        // Integer operations with precedence
        int result1 = a + b * c;       // Multiplication before addition
        int result2 = a * b + c;       // Multiplication before addition
        int result3 = c + a / b;       // Division before addition
        int result4 = a % b + c;       // Modulus before addition

        // Output: Display the results
        System.out.println("The results of Int Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        scanner.close();
    }
}
