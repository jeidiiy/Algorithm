package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] lessons = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int S = Integer.parseInt(split[0]);
            int T = Integer.parseInt(split[1]);

            lessons[i][0] = S;
            lessons[i][1] = T;
        }

        Arrays.sort(lessons, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int[] lesson : lessons) {
            if (!q.isEmpty() && q.peek() <= lesson[0]) {
                q.poll();
            }
            q.offer(lesson[1]);
        }

        System.out.print(q.size());
    }
}
