class Strings {
    public static void main(String[] args) {
        String s = "Hello";

        System.out.println("Length: " + s.length());
        System.out.println("Uppercase: " + s.toUpperCase());
        System.out.println("Reverse:");

        for (int i = s.length() - 1; i >= 0; i--)
            System.out.print(s.charAt(i));
    }
}
