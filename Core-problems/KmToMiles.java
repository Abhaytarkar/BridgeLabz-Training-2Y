import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        // Create Scanner object to take input from keyboard
        Scanner input = new Scanner(System.in);

        // Declare variable for kilometers
        double km;

        // Prompt user for input
        System.out.print("Enter distance in kilometers: ");
        km = input.nextInt();  // Read user input

        // Convert kilometers to miles
        double miles = km / 1.6;

        // Display the result
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
    }
}
