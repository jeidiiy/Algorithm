package baekjoon.math;

import java.io.*;

public class BOJ1747 {

    static boolean[] sieve;
    static final int MAX = 1_004_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(2);
            return;
        }

        sieve = new boolean[MAX + 1];
        setUp();
        int ans = findTarget(N);
        System.out.print(ans);
    }

    private static int findTarget(int N) {
        for (int i = N; i <= MAX; i++) {
            if (sieve[i] == false) {
                String num = String.valueOf(i);
                String start = num.substring(0, num.length() / 2);
                String end = num.substring(num.length() / 2);
                StringBuilder sb = new StringBuilder(end);
                end = sb.reverse().toString();

                if (end.startsWith(start))
                    return i;
            }
        }

        return -1;
    }

    private static void setUp() {
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (sieve[i] == true)
                continue;

            for (int j = i + i; j <= MAX; j += i) {
                sieve[j] = true;
            }
        }
    }
}
