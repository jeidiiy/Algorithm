package baekjoon.math;

import java.io.*;

public class BOJ13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);

        System.out.println(a > b ? (a * b) / gcd(a, b) : (a * b) / gcd(b, a));
    }

    private static long gcd(long a, long b) {
        long r = a % b;
        if (r == 0)
            return b;

        return gcd(b, r);
    }
}
