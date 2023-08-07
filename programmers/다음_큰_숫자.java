package programmers;

public class 다음_큰_숫자 {
    class Solution {
        public int solution(int n) {
            int nextBigNumber = n;
            int onecountOfBinaryN = countBinaryOne(Integer.toBinaryString(n));
            while (true) {
                nextBigNumber++;
                if (countBinaryOne(Integer.toBinaryString(nextBigNumber)) == onecountOfBinaryN)
                    break;
            }
            return nextBigNumber;
        }

        private int countBinaryOne(String s) {
            int result = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    result++;
            }

            return result;
        }
    }
}
