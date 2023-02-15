package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11725 {

    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] isVisited;
    static Integer[] answer;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            tree = new ArrayList[N];
            isVisited = new boolean[N];
            answer = new Integer[N];

            for (int i = 0; i < N; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; i++) {
                int[] edgeInfos = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).map(edgeInfo -> edgeInfo - 1).toArray();

                tree[edgeInfos[0]].add(edgeInfos[1]);
                tree[edgeInfos[1]].add(edgeInfos[0]);
            }

            dfs(0);
            // bfs();

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < N; i++) {
                sb.append(answer[i] + 1).append("\n");
            }

            System.out.print(sb);
        }
    }

    private static void dfs(int index) {
        isVisited[index] = true;
        for (Integer i : tree[index]) {
            if (!isVisited[i]) {
                answer[i] = index;
                dfs(i);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        isVisited[0] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            for (Integer node : tree[vertex]) {
                if (!isVisited[node]) {
                    isVisited[node] = true;
                    queue.add(node);
                    answer[node] = vertex;
                }
            }
        }
    }
}
