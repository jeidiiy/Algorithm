package baekjoon.math;

import java.io.*;

public class BOJ9020 {
    static final int RANGE = 10_000;
    static boolean[] sieve = new boolean[RANGE + 1];

    static {
        sieve[0] = sieve[1] = true;

        for (int i = 2; i <= Math.sqrt(sieve.length); i++) {
            if (sieve[i] == true)
                continue;

            for (int P = i * i; P < sieve.length; P += i) {
                sieve[P] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int p = n / 2;
            int q = n / 2;

            while (true) {
                if (sieve[p] == false && sieve[q] == false) {
                    sb.append(p + " " + q).append("\n");
                    break;
                }
                p--;
                q++;
            }
        }

        System.out.print(sb);
    }
}

