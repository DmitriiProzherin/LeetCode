package org.behemoth.Easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "race a car";
//        Character.
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = s.length()-1;
        int right = 0;

        while (right > left) {
            char rightChar = s.charAt(right);
            char leftChar = s.charAt(left);
            boolean check = true;

            if (!Character.isLetter(rightChar)) {
                right++;
                check = false;
            }
            if (!Character.isLetter(leftChar)) {
                left--;
                check = false;
            }
            if (check) {
                if (Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar)) return false;
                right++;
                left--;
            }
        }

        return true;
    }
}
