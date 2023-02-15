package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2644 {

    static int n;
    static int[] targets;
    static int cntOfRelationship;
    static ArrayList<Integer>[] tree;
    static boolean[] isVisited;
    static boolean isFamily = false;
    static int answer;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            targets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cntOfRelationship = Integer.parseInt(br.readLine());

            tree = new ArrayList[n + 1];
            isVisited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < cntOfRelationship; i++) {
                int[] relationships = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                tree[relationships[0]].add(relationships[1]);
                tree[relationships[1]].add(relationships[0]);
            }

            dfs(targets[0], 0);

            System.out.println(isFamily ? answer : -1);
        }
    }

    private static void dfs(int index, int count) {
        isVisited[index] = true;
        if (index == targets[1]) {
            answer = count;
            isFamily = true;
        }

        for (int i : tree[index]) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(i, count + 1);
            }
        }
    }
}
