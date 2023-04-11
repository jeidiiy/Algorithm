package baekjoon.math;

import java.io.*;

public class BOJ1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        long A = Long.parseLong(split[0]);
        long B = Long.parseLong(split[1]);

        long ans = A > B ? gcd(A, B) : gcd(B, A);

        System.out.print("1".repeat((int) ans));
    }

    private static long gcd(long a, long b) {
        long r = a % b;
        if (r == 0L) {
            return b;
        }

        return gcd(b, r);
    }
}
