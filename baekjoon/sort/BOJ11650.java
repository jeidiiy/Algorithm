package baekjoon.sort;

import java.io.*;
import java.util.*;

public class BOJ11650 {
    final static int X = 0;
    final static int Y = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][X] = Integer.parseInt(split[0]);
            arr[i][Y] = Integer.parseInt(split[1]);
        }

        Arrays.sort(arr, (p1, p2) -> {
            return p1[X] != p2[X] ? p1[X] - p2[X] : p1[Y] - p2[Y];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] p : arr) {
            sb.append(p[X]).append(" ").append(p[Y]).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());

        System.out.print(sb);
    }
}
