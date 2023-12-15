package org.behemoth.Medium;

import java.util.*;

class TopKFrequentElements {
    public static void main(String[] args) {

    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Pair[] pairs = new Pair[map.size()];

        int j = 0;
        for (var e : map.entrySet()) {
            pairs[j] = new Pair(e.getKey(), e.getValue());
            j++;
        }


        PriorityQueue<Pair> que = new PriorityQueue<>(List.of(pairs));

        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
                temp[i] = Objects.requireNonNull(que.poll()).getKey();
        }

        return temp;
    }

    private static class Pair implements Comparable<Pair> {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

        public int getKey(){
            return this.key;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.value, this.value);
        }
    }
}
