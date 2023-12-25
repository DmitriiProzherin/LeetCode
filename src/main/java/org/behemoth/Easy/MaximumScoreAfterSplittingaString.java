package org.behemoth.Easy;

import java.util.Arrays;

public class MaximumScoreAfterSplittingaString {
    public static void main(String[] args) {
        int[] sdf = new int[3];
        System.out.println(Arrays.toString(sdf));
    }

    public int maxScore(String s) {
        int n = s.length();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '0') scores[i]++;
            if (s.charAt(n - i - 1) == '1') scores[n - i - 1]++;
        }
        return Arrays.stream(scores).max().orElse(0);
    }
}
