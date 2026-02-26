

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";

        boolean isPalindrome = isPalindrome(input, 0, input.length() - 1);

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }


    public static boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
}