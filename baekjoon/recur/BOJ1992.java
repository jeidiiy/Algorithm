package recur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class BOJ1992 {
  private static int[][] map;
  private static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = br.readLine();
    String[] tokens;
    int N = Integer.parseInt(line);
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      line = br.readLine();
      tokens = line.split("");

      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    solution(0, 0, N);

    bw.write(sb.toString());

    br.close();
    bw.close();
  }

  private static void solution(int row, int col, int len) {
    if (checkNum(row, col, len)) {
      sb.append(map[row][col]);
      return;
    }

    int newLen = len / 2;

    sb.append("(");

    // 왼쪽 위에서부터 시계방향으로 실행
    solution(row, col, newLen);
    solution(row, col + newLen, newLen);
    solution(row + newLen, col, newLen);
    solution(row + newLen, col + newLen, newLen);

    sb.append(")");
  }

  private static boolean checkNum(int row, int col, int len) {
    int firstPosNum = map[row][col];

    for (int i = row; i < row + len; i++) {
      for (int j = col; j < col + len; j++) {
        if (map[i][j] != firstPosNum)
          return false;
      }
    }

    return true;
  }
}
