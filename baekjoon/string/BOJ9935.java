package baekjoon.string;

import java.io.*;

public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

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

        System.out.print(sb.length() == 0 ? "FRULA" : sb);
    }
}