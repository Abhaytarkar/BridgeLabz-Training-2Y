import java.util.Scanner;
public class GCDLCMCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.println("GCD: " + gcd(a, b));
        System.out.println("LCM: " + lcm(a, b));
    }
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}