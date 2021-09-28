package cipher;

import java.util.ArrayList;

public class Lcg {

    private static final int IV = 8;
    private static final int M = 16;
    private static final int A = 7;
    private static final int C = 3;
    private static final ArrayList<Integer> X = new ArrayList<>();
    private static final ArrayList<Double> R = new ArrayList<>();

    private static final int COUNT = 3000;

    private static double firstRand;
    private static int cycle;
    private static boolean checked;

    public static void main(String[] args) {

        X.add(IV);
        R.add(null);

        // 난수 충돌 체크를 위해 첫 난수 저장
        X.add(generateX(1));
        firstRand = generateR(1);
        R.add(firstRand);

        for (int i = 2; i <= COUNT; i++) {
            X.add(generateX(i));

            double rand = generateR(i);

            if (!checked) {
                if (rand == firstRand) {
                    cycle = i - 1;
                    checked = true;
                }
            }

            R.add(rand);
        }

        for (int i = 1; i <= 10; i++) {
            System.out.printf("X_%d = %d, R_%d = %.4f\n", i, X.get(i), i, R.get(i));
        }
        System.out.printf("cycle = %d", cycle);
    }

    private static int generateX(int i) {
        return (A * X.get(i - 1) + C) % M;
    }

    private static double generateR(int i) {
        return Math.round((double) X.get(i) / M * 10000) / 10000.0;
    }
}
