package baekjoon.math;

import java.io.*;

public class BOJ2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int count = 0;

        boolean[] sieve = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (sieve[i] == false) {
                for (int P = i; P <= N; P += i) {
                    if (sieve[P] == false) {
                        sieve[P] = true;
                        count++;
                        if (count == K) {
                            System.out.print(P);
                            return;
                        }
                    }
                }
            }
        }
    }
}
