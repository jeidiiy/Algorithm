package baekjoon.string;

import java.io.*;

public class BOJ10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int mid = str.length() / 2;
        String start = str.substring(0, mid);
        String end = str.substring(mid);
        StringBuilder sb = new StringBuilder(end);

        String reversedEnd = sb.reverse()
                .delete(str.length() % 2 == 1 ? sb.length() - 1 : sb.length(), sb.length())
                .toString();

        System.out.print(start.equals(reversedEnd) ? 1 : 0);
    }
}
