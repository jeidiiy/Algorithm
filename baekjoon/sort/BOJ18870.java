package baekjoon.sort;

import java.io.*;
import java.util.*;


public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> mapForRank = new HashMap<>();

        String[] Xs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            sorted[i] = origin[i] = Integer.parseInt(Xs[i]);
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int v : sorted) {
            if (!mapForRank.containsKey(v)) {
                mapForRank.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int key : origin) {
            int ranking = mapForRank.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.print(sb);
    }
}
