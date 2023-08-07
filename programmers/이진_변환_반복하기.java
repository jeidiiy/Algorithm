package programmers;

public class 이진_변환_반복하기 {
    class Solution {
        private int count = 0;
        private int zeros = 0;

        public int[] solution(String s) {
            convertToBinary(s);

            return new int[] { count, zeros };
        }

        private void convertToBinary(String s) {
            if (s.equals("1")) {
                return;
            }

            count++;

            int curZeros = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '0') {
                    curZeros++;
                    continue;
                }
            }
            zeros += curZeros;

            int len = s.length() - curZeros;

            convertToBinary(Integer.toBinaryString(len));
        }
    }
}
