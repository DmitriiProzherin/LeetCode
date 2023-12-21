package org.behemoth.Medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[] {2,3,10,5,7,8,9};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxSq = (height.length-1)*Math.min(height[r], height[l]);

        boolean fromLeft = true;
        while (r > l) {
            if (fromLeft) {
                l++;
                if (height[l] > height[l-1]) {
                    maxSq = Math.max(maxSq, (r-l)*Math.min(height[r], height[l]));
                }
                fromLeft = false;
            }
            else {
                r--;
                if (height[r] > height[r+1]) {
                    maxSq = Math.max(maxSq, (r-l)*Math.min(height[r], height[l]));
                }
                fromLeft = true;
            }
        }

        return maxSq;
    }
}
