package baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ17413 {
  public static void main(String[] argv) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    StringBuffer sb = new StringBuffer(input.length());
    boolean check = false;

    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '<') {
        appendReversedString(bw, sb);
        check = true;
        bw.write(input.charAt(i));
      } else if (input.charAt(i) == '>') {
        check = false;
        bw.write(input.charAt(i));
      } else if (check) {
        bw.write(input.charAt(i));
      } else {
        if (input.charAt(i) == ' ') {
          appendReversedString(bw, sb);
          bw.write(input.charAt(i));
        } else {
          sb.append(input.charAt(i));
        }
      }
    }

    appendReversedString(bw, sb);

    br.close();
    bw.close();
  }

  private static void appendReversedString(BufferedWriter bw, StringBuffer sb) throws IOException {
    bw.write(sb.reverse().toString());
    sb.delete(0, sb.length());
  }
}
