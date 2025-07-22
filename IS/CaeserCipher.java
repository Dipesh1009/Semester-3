public class CaeserCipher {

    /**
     * Calculates the GCD (Greatest Common Divisor) of two numbers using Euclidean algorithm.
     */
    public static int calculateGCD(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) return a;
        return calculateGCD(b, a % b);
    }

    /**
     * Removes all characters from the string except alphabets, removes spaces,
     * and converts all to lowercase using manual implementation.
     */
    public static String cleanText(String input) {
        StringBuilder cleaned = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (isUpperCase(c)) {
                cleaned.append(toLowerCaseManual(c + ""));
            } else if (isLowerCase(c)) {
                cleaned.append(c);
            }
            // Skip anything that's not a letter
        }

        return cleaned.toString();
    }

    /**
     * Encrypts the cleaned message using Caesar Cipher with a given key.
     */
    public static String caesarEncrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            int shifted = (c - 'a' + key) % 26;
            encrypted.append((char) ('a' + shifted));
        }

        return toUpperCaseManual(encrypted.toString());
    }

    /**
     * Decrypts a Caesar Cipher encrypted message (assumes input is all caps).
     */
    public static String caesarDecrypt(String encrypted, int key) {
        StringBuilder decrypted = new StringBuilder();
        String lowercase = toLowerCaseManual(encrypted);

        for (char c : lowercase.toCharArray()) {
            int shifted = (c - 'a' - key + 26) % 26;  // +26 to avoid negative result
            decrypted.append((char) ('a' + shifted));
        }

        return decrypted.toString(); // return as lowercase
    }

    /**
     * Converts lowercase string to uppercase manually.
     */
    public static String toUpperCaseManual(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (isLowerCase(c)) {
                result.append((char) (c - 32));
            } else {
                result.append(c); // Already uppercase or not a letter
            }
        }

        return result.toString();
    }

    /**
     * Converts uppercase string to lowercase manually.
     */
    public static String toLowerCaseManual(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (isUpperCase(c)) {
                result.append((char) (c + 32));
            } else {
                result.append(c); // Already lowercase or not a letter
            }
        }

        return result.toString();
    }

    /**
     * Helper to check if a character is uppercase.
     */
    public static boolean isUpperCase(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    /**
     * Helper to check if a character is lowercase.
     */
    public static boolean isLowerCase(char c) {
        return (c >= 'a' && c <= 'z');
    }

    /**
     * Main method to test all functionalities.
     */
    public static void main(String[] args) {
        int gcd = calculateGCD(56, 42);
        System.out.println("GCD of 42 and 56: " + gcd);

        String rawMessage = "Hello, World! Caesar Cipher Test, 123!";
        String cleaned = cleanText(rawMessage);
        System.out.println("Cleaned (lowercase, no spaces): " + cleaned);

        int key = 4;
        String encrypted = caesarEncrypt(cleaned, key);
        System.out.println("Encrypted Message (ALL CAPS): " + encrypted);

        String decrypted = caesarDecrypt(encrypted, key);
        System.out.println("Decrypted Message (lowercase): " + decrypted);
    }
}
