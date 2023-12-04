package org.behemoth.Easy;

public class MinimumTimeVisitAllPoints {
    public static void main(String[] args) {
        int[][] points = new int[][] {
                {1,1},{3,4},{-1,0}
        };
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int overallDistance = 0;
        for (int i = 1; i < points.length; i++) {
            overallDistance+=calculateDistance(points[i-1][0], points[i-1][1], points[i][0], points[i][1]);
        }
        return overallDistance;
    }

    private static int calculateDistance(int x1, int y1, int x2, int y2) {
        int distX = Math.abs(x2 - x1);
        int distY = Math.abs(y2 - y1);
        return Math.max(distX, distY);
    }
}
