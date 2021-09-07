package baekjoon.brute_force;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1018 : 체스판 다시 칠하기
 *
 * @author kdgyun
 * {@link https://st-lab.tistory.com}
 * {@link https://github.com/kdgyun}
 *
 */

public class BOJ1018 {

  static boolean[][] board; // 체스판은 흑백의 두 가지 경우이므로 흑=true, 백=false로 처리
  static int min = 64;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    board = new boolean[N][M];

    String input;
    for (int i = 0; i < N; i++) {
      input = br.readLine();
      for (int j = 0; j < M; j++) {
        if (input.charAt(j) == 'B')
          board[i][j] = true;
        else {
          board[i][j] = false;
        }
      }
    }

    int N_row = N - 7;
    int M_col = M - 7;

    for (int i = 0; i < N_row; i++) {
      for (int j = 0; j < M_col; j++) {
        solution(i, j);
      }
    }

    System.out.println(min);
  }

  static void solution(int x, int y) {
    int end_x = x + 8;
    int end_y = y + 8;
    int count = 0;

    boolean TF = board[x][y];

    for (int i = x; i < end_x; i++) {
      for (int j = y; j < end_y; j++) {

        // 올바른 색이 아닐 경우 카운트 증가
        if (board[i][j] != TF) {
          count++;
        }

        TF = (!TF);
      }

      TF = !TF;
    }

    count = Math.min(count, 64 - count);

    min = Math.min(min, count);
  }
}
