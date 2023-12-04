package org.behemoth.Easy;


public class Largest3SameDigitNumberInString {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("1118880"));
    }

    public static String largestGoodInteger(String num) {
        int indexNow = 0;
        int indexPrev = 0;
        int length = 0;
        char maxChar = ' ';

        while (indexNow < num.length()) {
            if (num.charAt(indexNow) != num.charAt(indexPrev)) {
                indexPrev = indexNow;
                indexNow++;
                length = 1;
            }
            else {
                length++;
                if (length == 3)
                    if (num.charAt(indexNow) > maxChar)
                        maxChar = num.charAt(indexNow);
                indexNow++;
            }

        }

        return maxChar == ' ' ? "" : (maxChar + "").repeat(3);
    }
}
