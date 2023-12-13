package org.behemoth.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring1(s));
    }

    // Bad O(n^2) solution
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int pointerNow = 0;
        int pointerSubstringStart = 0;
        int maxLength = 0;

        Map<String, Integer> map = new HashMap<>();

        while (pointerNow < s.length()) {
            if (!map.containsKey(s.substring(pointerNow, pointerNow+1))) {
                map.put(s.substring(pointerNow, pointerNow+1), pointerNow);
            }
            else {
                maxLength = Math.max(maxLength, pointerNow - pointerSubstringStart);
                if (map.get(s.substring(pointerNow, pointerNow+1)) > pointerSubstringStart)
                    pointerSubstringStart = map.get(s.substring(pointerNow, pointerNow+1));
            }
            pointerNow++;
        }

        return Math.max(maxLength, pointerNow - pointerSubstringStart);
    }

    // "abcabb" -> 3 ("abc)
    // "bbbbbb" -> 1 ("b)

    public static int lengthOfLongestSubstring1(String s) {
        int pointerNow = 0;
        int pointerPrev = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        Character currentChar;

        while (pointerNow < s.length()) {
            currentChar = s.charAt(pointerNow);

            if (!map.containsKey(currentChar)) {
                map.put(currentChar, pointerNow);
            }
            else {
                if (map.get(currentChar) >= pointerPrev) {
                    maxLength = Math.max(maxLength, pointerNow - pointerPrev);
                    pointerPrev = map.get(currentChar) + 1;
                    map.replace(currentChar, pointerNow);
                }
                else {
                    map.replace(currentChar, pointerNow);
                }
            }
            pointerNow++;

        }

        return Math.max(maxLength, pointerNow - pointerPrev);
    }

}
