package programmers;

public class 숫자_문자열과_영단어 {

    class Solution {

        String[] nums = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        public int solution(String s) {

            for (int i = 0; i < 10; i++) {
                s = s.replaceAll(nums[i], String.valueOf(i));
            }

            return Integer.parseInt(s);
        }
    }
}
