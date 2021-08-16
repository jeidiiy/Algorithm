package nt_com;

import java.io.*;

public class BOJ1934 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    int T = Integer.parseInt(br.readLine());

    String line;
    String[] tokens;
    int[] nums;
    int gcd, lcm;
    for (int i = 0; i < T; i++) {
      line = br.readLine();
      tokens = line.split(" ");

      nums = new int[2];
      nums[0] = Integer.parseInt(tokens[0]);
      nums[1] = Integer.parseInt(tokens[1]);

      gcd = gcd(nums[0], nums[1]);
      lcm = lcm(nums[0], nums[1], gcd);
      sb.append(lcm).append("\n");
    }

    bw.write(sb.toString());

    br.close();
    bw.close();

  }

  static int gcd(int a, int b) {
    int tmp;

    if (a < b) {
      tmp = a;
      a = b;
      b = tmp;
    }

    do {
      tmp = a % b;
      a = b;
      b = tmp;
    } while (b != 0);

    return a;
  }

  static int gcdRecur(int a, int b) {
    if (b == 0)
      return a;
    else
      return gcdRecur(b, a % b);
  }

  static int lcm(int a, int b, int gcd) {
    return (a / gcd) * (b / gcd) * gcd;
  }

}
