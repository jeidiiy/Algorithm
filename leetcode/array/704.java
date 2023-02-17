package leetcode.array;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivot = (left + right) / 2;
        int answer = -1;

        while (left <= right) {
            pivot = (left + right) / 2;

            if (nums[pivot] == target) {
                answer = pivot;
                break;
            }

            if (nums[pivot] < target) {
                left = pivot + 1;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            }
        }

        return answer;
    }
}
