package programmers;

public class 다음_큰_숫자 {
    class Solution {
        public int solution(int n) {
            int nextBigNumber = n;
            int onecountOfBinaryN = Integer.bitCount(n);
            while (true) {
                nextBigNumber++;
                if (Integer.bitCount(nextBigNumber) == onecountOfBinaryN)
                    break;
            }
            return nextBigNumber;
        }
    }
}
