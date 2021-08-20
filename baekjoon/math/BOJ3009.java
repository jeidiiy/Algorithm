package math;

import java.io.*;

public class BOJ3009 {

  final static int x = 0;
  final static int y = 1;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int[] p1 = new int[2];
    int[] p2 = new int[2];
    int[] p3 = new int[2];

    String[] tokens = br.readLine().split(" ");
    p1[x] = Integer.parseInt(tokens[x]);
    p1[y] = Integer.parseInt(tokens[y]);

    tokens = br.readLine().split(" ");
    p2[x] = Integer.parseInt(tokens[x]);
    p2[y] = Integer.parseInt(tokens[y]);

    tokens = br.readLine().split(" ");
    p3[x] = Integer.parseInt(tokens[x]);
    p3[y] = Integer.parseInt(tokens[y]);

    if (p1[x] == p2[x]) {
      sb.append(p3[x]);
    } else if (p2[x] == p3[x]) {
      sb.append(p1[x]);
    } else if (p1[x] == p3[x]) {
      sb.append(p2[x]);
    }

    sb.append(" ");

    if (p1[y] == p2[y]) {
      sb.append(p3[y]);
    } else if (p2[y] == p3[y]) {
      sb.append(p1[y]);
    } else if (p1[y] == p3[y]) {
      sb.append(p2[y]);
    }

    System.out.print(sb);

  }
}
