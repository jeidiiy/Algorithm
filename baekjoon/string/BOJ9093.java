package baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9093 {
  public static void main(String[] argv) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int taskcase = Integer.parseInt(br.readLine().trim());

    String input;
    String[] tokens;

    for (int i = 0; i < taskcase; i++) {
      input = br.readLine().trim();
      tokens = input.split(" ");

      for (int j = 0; j < tokens.length; j++) {
        String token = tokens[j];

        for (int k = 0; k < token.length(); k++) {
          bw.write(token.charAt(token.length() - (k + 1)));
        }
        bw.write(" ");
      }
      bw.write("\n");
    }

    br.close();
    bw.close();
  }
}
