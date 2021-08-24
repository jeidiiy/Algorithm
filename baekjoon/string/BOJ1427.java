package baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Character.*;

public class BOJ1427 {
  public static void main(String[] argv) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine().trim();

    Character[] chars = new Character[input.length()];

    for (int i = 0; i < input.length(); i++) {
      chars[i] = input.charAt(i);
    }

    Arrays.sort(chars, new Desc());

    StringBuffer sb = new StringBuffer(chars.length);
    for (Character c : chars) {
      sb.append(c.charValue());
    }

    bw.write(sb.toString());

    br.close();
    bw.close();
  }

  static class Desc implements Comparator<Character> {

    @Override
    public int compare(Character c1, Character c2) {
      return compare(toUpperCase(c1), toUpperCase(c2)) * -1;
    }
  }
}
