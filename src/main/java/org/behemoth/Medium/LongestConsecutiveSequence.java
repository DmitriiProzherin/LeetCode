package org.behemoth.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    // O(n), but bad constant
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Set<Integer> set = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int c = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            c = 1;
            int el = nums[i];
            if (set.contains(el)) {
                int r = el + 1;
                int l = el - 1;
                while (set.contains(r)) {
                    c+=1;
                    set.remove(r);
                    r+=1;
                }
                while (set.contains(l)) {
                    c+=1;
                    set.remove(l);
                    l-=1;
                }
            }
            max = Math.max(max, c);
        }


        return Math.max(max, c);
    }


    // O(nlogn)

    /*
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
    */
}
