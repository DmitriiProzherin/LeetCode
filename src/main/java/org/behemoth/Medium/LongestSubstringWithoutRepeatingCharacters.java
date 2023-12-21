package org.behemoth.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    // Bad O(n^2) solution
    /*
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
       */
    // "abcabb" -> 3 ("abc)
    // "bbbbbb" -> 1 ("b)


    // O(n)
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(100);
        char[] chars = s.toCharArray();
        int len = 0;
        int max = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                len+=1;
            }
            else {
                max = Math.max(max, len);
                start = Math.max(start, map.replace(chars[i], i));
                len = i - start;
            }
        }
        return Math.max(max, len);
    }

}
