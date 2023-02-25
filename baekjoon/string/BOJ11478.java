package baekjoon.string;

import java.io.*;
import java.util.*;

public class BOJ11478 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String S = br.readLine();
            Set<String> set = new HashSet<>();

            for (int i = 0; i < S.length(); i++)
                for (int j = i; j < S.length(); j++)
                    set.add(S.substring(i, j + 1));

            System.out.println(set.size());
        }
    }
}
