package programmers;

public class 숫자_카드_나누기 {
    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int gcd = arrayA[0];
            int resultA = 0;

            for (int i = 1; i < arrayA.length; i++) {
                gcd = gcd(gcd, arrayA[i]);
            }

            resultA = gcd;
            for (int i = 0; i < arrayB.length; i++) {
                if (arrayB[i] % gcd == 0) {
                    resultA = 0;
                    break;
                }
            }

            gcd = arrayB[0];
            int resultB = 0;

            for (int i = 1; i < arrayB.length; i++) {
                gcd = gcd(gcd, arrayB[i]);
            }

            resultB = gcd;
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] % gcd == 0) {
                    resultB = 0;
                    break;
                }
            }

            return Math.max(resultA, resultB);
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }

            return gcd(b, a % b);
        }
    }
}
