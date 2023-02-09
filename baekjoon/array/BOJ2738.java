package baekjoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2738 {
    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] size = br.readLine().split(" ");

            int N = Integer.parseInt(size[0]);
            int M = Integer.parseInt(size[1]);

            int[][] matrix = new int[N * 2][M];
            int[][] answer = new int[N][M];

            for (int i = 0; i < N * 2; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();

                for (int j = 0; j < M; j++) {
                    matrix[i][j] = line[j];
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    answer[i][j] = matrix[i][j] + matrix[i + N][j];
                    sb.append(answer[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}
