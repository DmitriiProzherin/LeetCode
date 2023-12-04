package org.behemoth.Easy;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        String[] words = new String[] {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));
    }
    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (var c : chars.toCharArray()) {
            if (characterMap.containsKey(c))
                characterMap.replace(c, characterMap.get(c) + 1);
            else characterMap.put(c, 1);
        }

        int overallLength = 0;
        for (var w : words) {
            Map<Character, Integer> tempMap = new HashMap<>(characterMap);
            boolean formingIsPossible = true;
            for (var c : w.toCharArray()) {
                if (!tempMap.containsKey(c)) {
                    formingIsPossible = false;
                    break;
                }
                else if (tempMap.replace(c, tempMap.get(c) - 1) == 0) {
                    formingIsPossible = false;
                    break;
                }
            }
            if (formingIsPossible) overallLength+= w.length();
        }

        return overallLength;
    }
}
