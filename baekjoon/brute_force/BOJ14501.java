package baekjoon.brute_force;

import java.io.*;

public class BOJ14501 {

    static int N, max;
    static int[] T, P;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            T = new int[N];
            P = new int[N];

            for (int i = 0; i < N; i++) {
                String[] split = br.readLine().split(" ");
                T[i] = Integer.parseInt(split[0]);
                P[i] = Integer.parseInt(split[1]);
            }

            solution(0, 0);

            System.out.println(max);
        }
    }

    private static void solution(int day, int pay) {
        // 퇴사하는 날이 되면 최대 급여를 계산한다.
        if (day == N) {
            max = Math.max(max, pay);
            return;
        }

        // 퇴사하는 날을 넘기면 종료한다.
        if (day > N)
            return;

        // 상담하는 날은 상담 기간과 날짜를 더한 값과 급여를 더해서 넘겨준다.
        solution(T[day] + day, P[day] + pay);

        // 상담하지 못하는 날은 날짜만 늘리고 넘겨준다.
        solution(day + 1, pay);
    }
}
