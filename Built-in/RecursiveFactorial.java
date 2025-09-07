import java.util.Scanner;
public class RecursiveFactorial {
    public static void main(String[] args) {
        int num = getInput();
        System.out.println("Factorial of " + num + " is " + factorial(num));
    }
    static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }
    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}