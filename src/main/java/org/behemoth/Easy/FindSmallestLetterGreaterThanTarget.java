package org.behemoth.Easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] array = new char[] {'b', 'c', 'j', 'm', 'm', 'p'};
        char target = 'm';
        System.out.println(nextGreatestLetter(array, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = -1;
        int right = letters.length - 1;
        int mid = 0;

        while (right > left) {
            mid = left + (right - left) / 2 + 1;
            if (letters[mid] == target) {
                System.out.println(left + " " + mid + " " + right);
                if (mid < letters.length - 1) return letters[mid + 1];
                else return letters[0];
            }
            else if (letters[mid] > target) right = mid - 1;
            else left = mid;
        }
        System.out.println(left + " " + mid + " " + right);
        if (left == letters.length - 1) return letters[0];
        else return letters[left];
    }
}
