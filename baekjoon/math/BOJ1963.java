package baekjoon.math;

import java.io.*;
import java.util.*;

public class BOJ1963 {

    private static final int MAX = 9999;
    private static int[] cnt;
    private static int[] d = {1000, 100, 10, 1};
    private static boolean[] isVisited;
    private static boolean[] sieve = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] split = br.readLine().split(" ");
            int src = Integer.parseInt(split[0]);
            int dst = Integer.parseInt(split[1]);
            cnt = new int[MAX + 1];
            isVisited = new boolean[MAX + 1];

            translate(src, dst);

            if (!isVisited[dst]) {
                sb.append("Impossible").append("\n");
            } else {
                sb.append(cnt[dst]).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void translate(int src, int dst) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        isVisited[src] = true;

        while (!q.isEmpty()) {
            int curPrime = q.poll();

            if (curPrime == dst) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int val = curPrime / d[i] / 10;
                int mod = curPrime % d[i];

                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0)
                        continue;

                    int next = (val * d[i] * 10) + (j * d[i]) + mod;
                    if (!isVisited[next] && !sieve[next]) {
                        q.offer(next);
                        isVisited[next] = true;
                        cnt[next] = cnt[curPrime] + 1;
                    }
                }
            }
        }
    }

    private static void init() {
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (sieve[i] == true)
                continue;

            for (int j = i + i; j <= MAX; j += i) {
                sieve[j] = true;
            }
        }
    }
}
