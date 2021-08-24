package baekjoon.math;

import java.io.*;
import static java.lang.Math.*;

public class BOJ1085 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();

    String[] tokens = input.split(" ");

    int x, y, w, h;
    int xTo0, xToW, yTo0, yToH;

    x = Integer.parseInt(tokens[0]);
    y = Integer.parseInt(tokens[1]);
    w = Integer.parseInt(tokens[2]);
    h = Integer.parseInt(tokens[3]);

    xTo0 = x;
    xToW = w - x;
    yTo0 = y;
    yToH = h - y;

    System.out.println(min(min(min(xTo0, xToW), yTo0), yToH));

  }
}
