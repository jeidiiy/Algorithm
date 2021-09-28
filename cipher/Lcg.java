package cipher;

import java.util.ArrayList;

public class Lcg {

    private static final int IV = 7;
    private static final int M = 16;
    private static final int A = 5;
    private static final int C = 3;
    private static final ArrayList<Integer> X = new ArrayList<>();
    private static final ArrayList<Double> R = new ArrayList<>();

    private static final int COUNT = 3000;

    public static void main(String[] args) {
        X.add(IV);
        R.add(null);

        for (int i = 1; i <= COUNT; i++) {
            X.add(generateX(i));
            R.add(generateR(i));
        }

        for (int i = 1; i <= 10; i++) {
            System.out.printf("X_%d = %d, R_%d = %.4f\n", i, X.get(i), i, R.get(i));
        }
    }

    private static int generateX(int i) {
        return (A * X.get(i - 1) + C) % M;
    }

    private static double generateR(int i) {
        return Math.round((double) X.get(i) / M * 10000) / 10000.0;
    }
}
