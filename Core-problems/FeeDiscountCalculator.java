import java.util.Scanner;

public class FeeDiscountCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user input for fee
        System.out.print("Enter the student fee (INR): ");
        double fee = input.nextDouble();

        // Take user input for discount percentage
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = input.nextDouble();

        // Calculate discount amount
        double discount = (discountPercent / 100) * fee;

        // Calculate final fee after discount
        double finalFee = fee - discount;

        // Display the result
        System.out.println(
            "The discount amount is INR " + discount +
            " and final discounted fee is INR " + finalFee
        );
    }
}
