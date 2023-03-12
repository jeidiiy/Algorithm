package baekjoon.string;

import java.io.*;

public class BOJ1213 {

    static int[] alphabets = new int[26];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[] name = br.readLine().toCharArray();

            for (char alphabet : name) {
                alphabets[alphabet - 'A']++;
            }

            // 홀수 개인 알파벳이 2개 이상이면 불가능
            int isOnlyOne = 0;
            for (int i = 0; i < alphabets.length; i++) {
                if (alphabets[i] % 2 != 0)
                    isOnlyOne++;
            }

            String answer = "";
            StringBuilder sb = new StringBuilder();

            if (isOnlyOne > 1)
                answer = "I'm Sorry Hansoo";
            else {
                for (int i = 0; i < alphabets.length; i++) {
                    for (int j = 0; j < alphabets[i] / 2; j++) {
                        sb.append((char) (i + 65));
                    }
                }

                answer += sb.toString();

                for (int i = 0; i < alphabets.length; i++) {
                    if (alphabets[i] % 2 == 1)
                        sb.append((char) (i + 65));
                }

                answer += sb.reverse().toString();
            }

            System.out.println(answer);
        }
    }
}
