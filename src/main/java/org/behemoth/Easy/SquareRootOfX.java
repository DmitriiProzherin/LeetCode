package org.behemoth.Easy;

import java.util.*;

public class SquareRootOfX {
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(6));
        System.out.println(mySqrt(36));

        List<Integer> result = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        set.stream()
                .mapToInt(e -> e)
                .toArray();

        int[] sdf = new int[] {1, 2, 3, 4 };
//        Collections.addAll(set, );

        int[] r = result.stream()
                .mapToInt(x -> x)
                .toArray();
    }

    public static int mySqrt(int x) {

        int left = 0;
        int right = x;
        int mid;

        while (square(left) <= x) {
            mid = left + (right - left) / 2;
            if (square(mid) == x) return mid;
            else if (square(mid) > x ) right = mid;
            else left = mid+1;
        }

        return left-1;
    }

    private static long square(int a){
        return (long) a*a;
    }
}
