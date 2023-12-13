package org.behemoth.Medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        String s = "sdsf";
        char[] ca = new char[26];
        for (char c : s.toCharArray()) ca[c - 'a']++;
        String keyStr = new String(ca);
        System.out.println(keyStr);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (var str : strs) {
            String key = getKey(str);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private static String getKey(String string) {
        int[] arr = new int[26];
        for (var ch : string.toCharArray()) {
            arr[ch - 'a']++;
        }
        return Arrays.toString(arr);
    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String[], List<String>> mapOfLists = new HashMap<>();
//        List<List<String>> resList = new LinkedList<>();
//
//        for (String str : strs) {
//            String[] arrayKey = calcStrArray(str);
//            if (!mapOfLists.containsKey(arrayKey)) {
//                List<String> list = new LinkedList<>();
//                mapOfLists.put(arrayKey, list);
//                list.add(str);
//            } else {
//                mapOfLists.get(arrayKey).add(str);
//            }
//        }
//
//        for (var e : mapOfLists.entrySet()) {
//            resList.add(e.getValue());
//        }
//
//        return resList;
//    }
//
//    private static String[] calcStrArray(String str){
//        int aCode = 'a';
//        int[] letters = new int[26];
//        String[] resArray = new String[26];
//
//        for (int i = 0; i < str.length(); i++) {
//            letters[str.charAt(i) - aCode]+=1;
//        }
//
//        for (int i = 0; i < letters.length; i++) {
//            resArray[i] = "" + letters[i] + (char) (aCode + i);
//        }
//
//        System.out.println(Arrays.toString(resArray));
//        return resArray;
//    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> resList = new LinkedList<>();
//        Map<Map<Character, Integer>, List<String>> mapOfLists = new HashMap<>();
//
//        for (int i = 0; i < strs.length; i++) {
//            Map<Character, Integer> tempMap = calcMap(strs[i]);
//            if (!mapOfLists.containsKey(tempMap)) {
//                mapOfLists.put(tempMap, new LinkedList<>());
//                mapOfLists.get(tempMap).add(strs[i]);
//            }
//            else {
//                mapOfLists.get(tempMap).add(strs[i]);
//            }
//        }
//
//        for (var e : mapOfLists.entrySet()) {
//            resList.add(e.getValue());
//        }
//
//        return resList;
//    }
//
//    private static Map<Character, Integer> calcMap(String str) {
//        Map<Character, Integer> resMap = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (!resMap.containsKey(str.charAt(i))) resMap.put(str.charAt(i), 1);
//            else {
//                int current = resMap.get(str.charAt(i));
//                resMap.replace(str.charAt(i),  current + 1);
//            }
//        }
//        return resMap;
//    }
}
