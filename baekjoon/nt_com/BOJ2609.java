package baekjoon.nt_com;

import java.io.*;

public class BOJ2609 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String line = br.readLine();
    String[] tokens = line.split(" ");

    int[] nums = new int[2];
    nums[0] = Integer.parseInt(tokens[0]);
    nums[1] = Integer.parseInt(tokens[1]);

    int gcd = gcd(nums[0], nums[1]);
    int lcm = lcm(nums[0], nums[1], gcd);
    sb.append(gcd).append("\n").append(lcm);
    System.out.print(sb.toString());
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