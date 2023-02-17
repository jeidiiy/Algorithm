package leetcode.array;

import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum();

        int answer = -1;
        int tmp = 0;

        for (int pivotIdx = 0; pivotIdx < nums.length; pivotIdx++) {
            leftSum += tmp;
            rightSum -= nums[pivotIdx];

            if (leftSum == rightSum) {
                answer = pivotIdx;
                break;
            }

            tmp = nums[pivotIdx];
        }

        return answer;
    }
}
