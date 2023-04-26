package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensors =
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(sensors);

        int[] diffs = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diffs[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(diffs);

        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += diffs[i];
        }

        System.out.print(answer);
    }
}
