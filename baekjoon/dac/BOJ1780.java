package baekjoon.dac;

import java.io.*;

public class BOJ1780 {

  static int[][] arr;
  static int mOne = 0;
  static int zero = 0;
  static int pOne = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    arr = new int[N][N];

    String input;
    String[] tokens;

    for (int i = 0; i < N; i++) {
      input = br.readLine();
      tokens = input.split(" ");

      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    findNumOfPaper(0, 0, N);

    System.out.println(mOne);
    System.out.println(zero);
    System.out.println(pOne);
  }

  static void findNumOfPaper(int x, int y, int N) {

    if (checkNum(x, y, N)) {
      if (arr[x][y] == -1) {
        mOne++;
        return;
      }
      if (arr[x][y] == 0) {
        zero++;
        return;
      }
      if (arr[x][y] == 1) {
        pOne++;
        return;
      }
    }

    N = N / 3;

    findNumOfPaper(x, y, N);
    findNumOfPaper(x + N, y, N);
    findNumOfPaper(x + 2 * N, y, N);

    findNumOfPaper(x, y + N, N);
    findNumOfPaper(x + N, y + N, N);
    findNumOfPaper(x + 2 * N, y + N, N);

    findNumOfPaper(x, y + 2 * N, N);
    findNumOfPaper(x + N, y + 2 * N, N);
    findNumOfPaper(x + 2 * N, y + 2 * N, N);
  }

  static boolean checkNum(int x, int y, int N) {
    for (int i = x; i < x + N; i++) {
      for (int j = y; j < y + N; j++) {
        if (arr[x][y] != arr[i][j])
          return false;
      }
    }

    return true;
  }
}