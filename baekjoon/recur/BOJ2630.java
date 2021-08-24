package baekjoon.recur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2630 {

  private static int[][] map;

  private static int cntForWhite;
  private static int cntForBlue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = br.readLine();
    String[] tokens;
    int N = Integer.parseInt(line);
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      line = br.readLine();
      tokens = line.split(" ");

      for (int j = 0; j < tokens.length; j++) {
        map[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    recur(0, 0, N);

    bw.write(String.valueOf(cntForWhite) + "\n");
    bw.write(String.valueOf(cntForBlue));

    br.close();
    bw.close();
  }

  public static void recur(int row, int col, int len) {
    if (checkSquare(row, col, len)) {
      if (map[row][col] == 0) {
        cntForWhite++;
      } else {
        cntForBlue++;
      }
      return;
    }

    int newLen = len / 2;

    recur(row, col + newLen, newLen); // 1사분면
    recur(row, col, newLen); // 2사분면
    recur(row + newLen, col, newLen); // 3사분면
    recur(row + newLen, col + newLen, newLen); // 4사분면
  }

  public static boolean checkSquare(int row, int col, int len) {
    int firstPosColor = map[row][col];

    for (int i = row; i < row + len; i++) {
      for (int j = col; j < col + len; j++) {
        if (map[i][j] != firstPosColor)
          return false;
      }
    }

    return true;
  }
}
