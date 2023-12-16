package org.behemoth.Easy;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "nl";
        String t = "cx";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] map1 = new char['z'-'a' + 1];
        char[] map2 = new char['z'-'a' + 1];

        for (int i = 0; i < s.length(); i++) {
            map1[s.charAt(i) - 'a'] += 1;
            map2[t.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < map1.length; i++) {
            if (map1[i] != map2[i]) return false;
        }

        return true;
    }
}
