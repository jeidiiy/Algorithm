package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2251 {

    static int A, B, C;
    static boolean[][][] isVisited;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setup();
        bfs();
        printAnswer();
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        A = Integer.parseInt(split[0]);
        B = Integer.parseInt(split[1]);
        C = Integer.parseInt(split[2]);

        isVisited = new boolean[A + 1][B + 1][C + 1];
    }

    private static void bfs() {
        Queue<BucketState> q = new LinkedList<>();
        q.add(new BucketState(0, 0, C));

        while (!q.isEmpty()) {
            BucketState curBS = q.poll();

            // 이미 확인한 경우 패스
            if (isVisited[curBS.a][curBS.b][curBS.c])
                continue;

            isVisited[curBS.a][curBS.b][curBS.c] = true;

            // A가 비어있으면 C값 저장
            if (curBS.a == 0)
                ans.add(curBS.c);

            // B to A
            if (curBS.a + curBS.b > A) { // 두 합이 A보다 크면 A를 가득 채우고 나머지는 B에 둔다.
                q.add(new BucketState(A, curBS.a + curBS.b - A, curBS.c));
            } else { // 두 합이 A보다 작거나 같으면 전부 A로 옮긴다.
                q.add(new BucketState(curBS.a + curBS.b, 0, curBS.c));
            }

            // C to A
            if (curBS.a + curBS.c > A) { // 두 합이 A보다 크면 A를 가득 채우고 나머지는 C에 둔다.
                q.add(new BucketState(A, curBS.b, curBS.a + curBS.c - A));
            } else { // 두 합이 A보다 작거나 같으면 전부 A로 옮긴다.
                q.add(new BucketState(curBS.a + curBS.c, curBS.b, 0));
            }

            // A to B
            if (curBS.b + curBS.a > B) { // 두 합이 B보다 크면 B를 가득 채우고 나머지는 A에 둔다.
                q.add(new BucketState(curBS.b + curBS.a - B, B, curBS.c));
            } else { // 두 합이 B보다 작거나 같으면 전부 B로 옮긴다.
                q.add(new BucketState(0, curBS.b + curBS.a, curBS.c));
            }

            // C to B
            if (curBS.c + curBS.b > B) { // 두 합이 B보다 크면 B를 가득 채우고 나머지는 C에 둔다.
                q.add(new BucketState(curBS.a, B, curBS.c + curBS.b - B));
            } else { // 두 합이 B보다 작거나 같으면 전부 B로 옮긴다.
                q.add(new BucketState(curBS.a, curBS.c + curBS.b, 0));
            }

            // A to C
            if (curBS.c + curBS.a > C) { // 두 합이 C보다 크면 C를 가득 채우고 나머지는 A에 둔다.
                q.add(new BucketState(curBS.c + curBS.a - C, curBS.b, C));
            } else { // 두 합이 C보다 작거나 같으면 전부 C로 옮긴다.
                q.add(new BucketState(0, curBS.b, curBS.c + curBS.a));
            }

            // B to C
            if (curBS.c + curBS.b > C) { // 두 합이 C보다 크면 C를 가득 채우고 나머지는 B에 둔다.
                q.add(new BucketState(curBS.a, curBS.c + curBS.b - C, C));
            } else { // 두 합이 C보다 작거나 같으면 전부 C로 옮긴다.
                q.add(new BucketState(curBS.a, 0, curBS.c + curBS.b));
            }
        }
    }

    private static void printAnswer() {
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Integer i : ans) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    private static class BucketState {
        int a;
        int b;
        int c;

        public BucketState(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
