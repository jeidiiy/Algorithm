package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1026 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        String A = br.readLine();
        String B = br.readLine();

        String[] a = A.split(" ");
        String[] b = B.split(" ");

        PriorityQueue<Integer> queueForA = new PriorityQueue<>();
        PriorityQueue<Integer> queueForB = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        for (int i = 0; i < N; i++) {
            queueForA.add(Integer.parseInt(a[i]));
            queueForB.add(Integer.parseInt(b[i]));
        }

        for (int i = 0; i < N; i++) {
            sum += queueForA.poll() * queueForB.poll();
        }

        System.out.println(sum);
    }
}
