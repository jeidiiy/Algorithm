package baekjoon.brute_force;

import java.io.*;

public class BOJ9663 {

    static int N;
    static int count;
    static int[] chessboard;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            chessboard = new int[N];

            nQueen(0);
            System.out.println(count);
        }
    }

    private static void nQueen(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            chessboard[row] = i;

            if (isPossible(row)) {
                nQueen(row + 1);
            }
        }
    }

    private static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (chessboard[row] == chessboard[i])
                return false;
            else if (Math.abs(row - i) == Math.abs(chessboard[row] - chessboard[i]))
                return false;
        }

        return true;
    }
}
