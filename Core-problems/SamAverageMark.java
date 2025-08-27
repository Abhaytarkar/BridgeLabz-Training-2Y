public class SamAverageMark {
    public static void main(String[] args) {
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate total and average
        int totalMarks = maths + physics + chemistry;
        double average = totalMarks / 3.0;

        // Output the result
        System.out.println("Sam’s average mark in PCM is " + average);
    }
}
