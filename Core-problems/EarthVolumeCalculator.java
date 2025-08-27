public class EarthVolumeCalculator {
    public static void main(String[] args) {
        double radiusKm = 6378; // Radius of Earth in kilometers
        double pi = Math.PI;

        // Volume of Earth in cubic kilometers
        double volumeKm3 = (4.0 / 3.0) * pi * Math.pow(radiusKm, 3);

        // Conversion factor: 1 km = 0.621371 miles
        // So, 1 km³ = (0.621371)^3 miles³
        double conversionFactor = Math.pow(0.621371, 3);
        double volumeMiles3 = volumeKm3 * conversionFactor;

        // Output the result
        System.out.println(
            "The volume of earth in cubic kilometers is " + volumeKm3 +
            " and cubic miles is " + volumeMiles3
        );
    }
}
