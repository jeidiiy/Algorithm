package baekjoon.math;

import java.io.*;

public class BOJ25206 {

    final static int COUNT_ENROLLED_CLASS = 20;
    final static float[] GRADE = {4.5f, 4.0f, 3.5f, 3.0f, 2.5f, 2.0f, 1.5f, 1.0f, 0.0f};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float total = 0;
        float sum = 0;

        for (int i = 0; i < COUNT_ENROLLED_CLASS; i++) {
            String[] infos = br.readLine().split(" ");
            float credit = Float.parseFloat(infos[1]);
            switch (infos[2]) {
                case "A+":
                    sum += credit * GRADE[0];
                    break;
                case "A0":
                    sum += credit * GRADE[1];
                    break;
                case "B+":
                    sum += credit * GRADE[2];
                    break;
                case "B0":
                    sum += credit * GRADE[3];
                    break;
                case "C+":
                    sum += credit * GRADE[4];
                    break;
                case "C0":
                    sum += credit * GRADE[5];
                    break;
                case "D+":
                    sum += credit * GRADE[6];
                    break;
                case "D0":
                    sum += credit * GRADE[7];
                    break;
                case "F":
                    sum += credit * GRADE[8];
                    break;
                case "P":
                    total -= credit; // 총합에서 패스 과목은 빼야하기 때문에 제거
                default:
                    break;
            }
            total += credit;
        }
        System.out.print(String.format("%.6f", sum / total));
    }
}
