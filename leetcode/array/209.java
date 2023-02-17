package leetcode.array;

class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int sum = 0, start = 0, end = 0, ans = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end++];

            while (sum >= target) {
                ans = Math.min(ans, end - start);
                sum -= nums[start++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
