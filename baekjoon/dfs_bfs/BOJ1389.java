package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ1389 {

    static int N, M;
    static boolean[][] network;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        network = new boolean[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);

            network[A][B] = true;
            network[B][A] = true;
        }

        Relation result = bfs();
        System.out.print(result.me);
    }

    private static Relation bfs() {
        Queue<Relation> q = new LinkedList<>();
        Relation min = new Relation(0, 0, Integer.MAX_VALUE);

        for (int me = 1; me <= N; me++) {
            q.offer(new Relation(me, 1, 0));
            isVisited[me] = true;
            int kevinBacon = 0;

            while (!q.isEmpty()) {
                Relation r = q.poll();
                kevinBacon += r.cnt;

                for (int you = 1; you <= N; you++) {
                    if (!isVisited[you] && network[r.me][you] == true) {
                        isVisited[you] = true;
                        q.offer(new Relation(you, 1, r.cnt + 1));
                    }
                }
            }

            if (min.cnt > kevinBacon) {
                min = new Relation(me, 0, kevinBacon);
            } else if (min.cnt == kevinBacon) {
                if (min.me > me)
                    min = new Relation(me, 0, kevinBacon);
            }

            isVisited = new boolean[N + 1];
        }

        return min;
    }

    static class Relation {
        int me;
        int you;
        int cnt;

        public Relation(int me, int you, int cnt) {
            this.me = me;
            this.you = you;
            this.cnt = cnt;
        }
    }
}
