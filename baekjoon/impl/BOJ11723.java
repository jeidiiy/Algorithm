package baekjoon.impl;

import java.io.*;

public class BOJ11723 {
    private static final StringBuilder sb = new StringBuilder();
    private static final boolean[] set = new boolean[21];

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; i++) {
                String input = br.readLine();
                String[] tokens = input.split(" ");

                String command = tokens[0];
                int num = 0;

                switch (command) {
                    case "add":
                        num = Integer.parseInt(tokens[1]);
                        set[num] = true;
                        break;
                    case "remove":
                        num = Integer.parseInt(tokens[1]);
                        set[num] = false;
                        break;
                    case "check":
                        num = Integer.parseInt(tokens[1]);
                        sb.append(set[num] == true ? "1\n" : "0\n");
                        break;
                    case "toggle":
                        num = Integer.parseInt(tokens[1]);
                        if (set[num] == true) {
                            set[num] = false;
                        } else {
                            set[num] = true;
                        }
                        break;
                    case "all":
                        for (int j = 1; j < set.length; j++) {
                            set[j] = true;
                        }
                        break;
                    case "empty":
                        for (int j = 1; j < set.length; j++) {
                            set[j] = false;
                        }
                        break;
                }
            }
            bw.write(sb.toString());
        }
    }
}
