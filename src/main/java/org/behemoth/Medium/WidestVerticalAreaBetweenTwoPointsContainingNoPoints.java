package org.behemoth.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args) {

    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        int cur = points[0][0];
        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - cur);
            cur = points[i][0];
        }
        return max;
    }
}
