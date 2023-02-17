package leetcode.array;

class Solution {
    public void moveZeroes(int[] nums) {

        swap(nums);
        copy(nums);

    }

    private void swap(int[] nums) {
        int wIdx = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] != 0) {
                int tmp = nums[wIdx];
                nums[wIdx] = nums[idx];
                nums[idx] = tmp;

                wIdx++;
            }
        }
    }

    private void copy(int[] nums) {
        int wIdx = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] != 0) {
                nums[wIdx] = nums[idx];
                wIdx++;
            }
        }
        for (; wIdx < nums.length; wIdx++) {
            nums[wIdx] = 0;
        }
    }
}
