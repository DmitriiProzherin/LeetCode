package org.behemoth.Easy;


class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 9};
        int target = 2;
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length, medium;

        if (target <= nums[0]) return 0;

        while (right > left + 1) {
            medium = left + (right - left)/2;
            if (nums[medium] == target) return medium;
            else if (nums[medium] > target) {
                right = medium;
            }
            else {
                left = medium;
            }
        }

        return right;
    }
}
