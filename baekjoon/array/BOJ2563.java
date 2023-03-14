package baekjoon.array;

import java.io.*;

public class BOJ2563 {

    static boolean[][] paper = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int i = 0; i < N; i++) {
                String[] split = br.readLine().split(" ");

                int px = Integer.parseInt(split[0]);
                int py = Integer.parseInt(split[1]);

                for (int x = px; x < px + 10; x++) {
                    for (int y = py; y < py + 10; y++) {
                        if (!paper[x][y]) {
                            answer++;
                            paper[x][y] = true;
                        }
                    }
                }
            }

            System.out.print(answer);
        }
    }
}
