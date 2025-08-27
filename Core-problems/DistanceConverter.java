import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read distance in feet
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = scanner.nextDouble();

        // Conversion factors
        double feetPerYard = 3.0;
        double yardsPerMile = 1760.0;

        // Calculate distance in yards and miles
        double distanceInYards = distanceInFeet / feetPerYard;
        double distanceInMiles = distanceInYards / yardsPerMile;

        // Output: Display the results
        System.out.printf("The distance in yards is %.2f while the distance in miles is %.4f\n",
                          distanceInYards, distanceInMiles);

        scanner.close();
    }
}
