package baekjoon.nt_com;

import java.io.*;
import java.util.Arrays;

public class BOJ1037 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    String input = br.readLine();
    String[] tokens = input.split(" ");
    int[] divisors = new int[tokens.length];

    for (int i = 0; i < divisors.length; i++) {
      divisors[i] = Integer.parseInt(tokens[i]);
    }

    Arrays.sort(divisors);

    System.out.println(divisors[0] * divisors[divisors.length - 1]);
  }
}