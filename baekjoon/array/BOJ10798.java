package baekjoon.array;

import java.io.*;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 5;
        int M = 15;
        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                arr[i][j] = chars[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[j][i] != '\u0000') {
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.print(sb);
    }
}
