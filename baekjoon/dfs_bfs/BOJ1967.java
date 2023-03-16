package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ1967 {

    static int N, maxNodeIdx, max = Integer.MIN_VALUE;
    static ArrayList<Node> tree[];
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int[] nodeInfo =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int parent = nodeInfo[0];
            int child = nodeInfo[1];
            int weight = nodeInfo[2];

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        isVisited = new boolean[N + 1];
        isVisited[1] = true;
        dfs(1, 0);

        isVisited = new boolean[N + 1];
        isVisited[maxNodeIdx] = true;
        dfs(maxNodeIdx, 0);

        System.out.print(max);
    }

    private static void dfs(int idx, int sum) {
        if (max < sum) {
            max = sum;
            maxNodeIdx = idx;
        }

        for (Node next : tree[idx]) {
            if (!isVisited[next.node]) {
                isVisited[next.node] = true;
                dfs(next.node, sum + next.weight);
            }
        }
    }

    private static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
