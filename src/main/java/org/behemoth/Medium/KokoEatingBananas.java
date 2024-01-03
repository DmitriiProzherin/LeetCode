package org.behemoth.Medium;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int r = Arrays.stream(piles).max().orElse(1);
        int l = 1;
        int m = 1;
        int hours;

        while (r>l){
            m = l + (r-l)/2;
            hours = tryToEat(piles, m);
            if (hours <= h) r = m;
            else l = m +1;
        }
        return l;
    }

    private static int tryToEat(int[] piles, int k) {
        int time = 0;
        for (int el : piles) {
            time += (el/k) + (el%k == 0 ? 0 : 1);
        }
        return time;
    }
}
