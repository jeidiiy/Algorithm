package baekjoon.math;

import java.io.*;
import java.math.BigInteger;

public class BOJ10757 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tokens = br.readLine().split(" ");

    BigInteger a = new BigInteger(tokens[0]);
    BigInteger b = new BigInteger(tokens[1]);

    System.out.println(a.add(b));
  }
}
