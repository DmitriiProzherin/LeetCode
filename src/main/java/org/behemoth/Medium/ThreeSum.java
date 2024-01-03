package org.behemoth.Medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,0,1,2,-1,-4};

        threeSum(nums1).forEach(System.out::println);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i+1]) continue;
            else {
                target = -nums[i];
                index = i;
                // Two sum search
                int l = i + 1;
                int r = nums.length-1;

                while (l < r) {
                    if (nums[l] + nums[r] > target) {
                        r--;
                    }
                    else if (nums[l] + nums[r] < target){
                        l++;
                    }
                    else {
                        res.add(Arrays.asList(nums[index], nums[l], nums[r]));
                        l++;
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
