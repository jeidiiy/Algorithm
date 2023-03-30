package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ1049 {

    static final int stringsCount = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int MIN = Integer.MAX_VALUE;

        int[] packages = new int[M];
        int[] pieces = new int[M];

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            packages[i] = Integer.parseInt(split[0]);
            pieces[i] = Integer.parseInt(split[1]);
        }

        Arrays.sort(packages);
        Arrays.sort(pieces);

        MIN = Math.min(((N / stringsCount) + 1) * packages[0], N * pieces[0]);
        MIN = Math.min(MIN, ((N / stringsCount)) * packages[0] + (N % stringsCount) * pieces[0]);

        System.out.print(MIN);
    }
}
