package baekjoon.math;

import java.io.*;

public class BOJ2023 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        judgeInterestingPrime(2, 1);
        judgeInterestingPrime(3, 1);
        judgeInterestingPrime(5, 1);
        judgeInterestingPrime(7, 1);
    }

    private static void judgeInterestingPrime(int num, int digit) {
        if (digit == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int next = num * 10 + i;

            if (isPrime(next)) {
                judgeInterestingPrime(next, digit + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
