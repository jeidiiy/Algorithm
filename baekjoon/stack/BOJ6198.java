package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class BOJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> buildings = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        long count = 0;
        for (int i = 0; i < N; i++) {
            int building = Integer.parseInt(br.readLine());

            while (!buildings.isEmpty() && buildings.peek() <= building) {
                buildings.pop();
            }

            count += buildings.size();
            buildings.push(building);
        }

        System.out.print(count);
    }
}
