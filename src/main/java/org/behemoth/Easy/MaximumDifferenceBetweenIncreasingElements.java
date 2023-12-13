package org.behemoth.Easy;

public class MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {
        int[] nums = new int[] {7, 1, 5, 4};
        System.out.println(maximumDifference(nums));
    }

    public static int maximumDifference(int[] nums) {
        int min = 0;
        int max = 1;
        int difference = nums[max] - nums[min];

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] >= nums[max]) {
                max = i;
                min = calcMin(nums, min, i);
                if (nums[max] - nums[min] >= 0)
                    difference = nums[max] - nums[min];
            }
        }

        return difference >= 0 ? difference : -1;
    }

    private static int calcMin(int[] nums, int start, int end) {
        int res = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[start]) res = i;
        }
        return res;
    }
}
