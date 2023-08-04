package programmers;

public class 최댓값과_최솟값 {
    class Solution {
        public String solution(String s) {
            String[] strnums = s.split(" ");

            int[] nums = new int[strnums.length];
            for (int i = 0; i < strnums.length; i++) {
                nums[i] = Integer.parseInt(strnums[i]);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }

                if (nums[i] < min) {
                    min = nums[i];
                }
            }

            return min + " " + max;
        }
    }
}
