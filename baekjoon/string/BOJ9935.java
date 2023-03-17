package baekjoon.string;

import java.io.*;
import java.util.Stack;

public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        System.out.println(solveByStringBuilder(str, bomb));
        System.out.println(solveByStack(str, bomb));
    }

    private static String solveByStringBuilder(String str, String bomb) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            sb.append(cur);

            if (sb.length() >= bomb.length()) {
                boolean isExplode = true;
                for (int j = 0; j < bomb.length(); j++) {
                    char ch1 = sb.charAt(sb.length() - bomb.length() + j);
                    char ch2 = bomb.charAt(j);

                    if (ch1 != ch2) {
                        isExplode = false;
                        break;
                    }
                }

                if (isExplode) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }

        return sb.length() == 0 ? "FRULA" : sb.toString();
    }

    private static String solveByStack(String str, String bomb) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            s.push(cur);

            if (s.size() >= bomb.length()) {
                boolean isExplode = true;
                for (int j = 0; j < bomb.length(); j++) {
                    char ch1 = s.get(s.size() - bomb.length() + j);
                    char ch2 = bomb.charAt(j);

                    if (ch1 != ch2) {
                        isExplode = false;
                        break;
                    }
                }

                if (isExplode) {
                    for (int j = 0; j < bomb.length(); j++)
                        s.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.size(); i++)
            sb.append(s.get(i));

        return sb.length() == 0 ? "FRULA" : sb.toString();
    }
}
