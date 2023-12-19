package org.behemoth.Medium;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }


    // Time: O(nlogn)
    // Space: O(1)
    public static int longestConsecutive(int[] nums){
        if (nums.length == 0 || nums == null) return 0;

        Arrays.sort(nums);
        int c = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]+1) c++;
            else if (nums[i] == nums[i-1]) {
                continue;
            } else {
                max = Math.max(max, c);
                c = 1;
            }
        }

        return Math.max(max, c);
    }
}
