class UniqueStringChars {
    public static void main(String[] args) {
        String s = "abcdef";
        boolean unique = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    unique = false;
                    break;
                }
            }
        }

        System.out.println(unique ? "Unique Characters" : "Not Unique");
    }
}

