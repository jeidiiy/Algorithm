package baekjoon.string;

import java.io.*;
import java.util.stream.*;
import java.util.*;

public class BOJ1764 {

    static Set<String> deudjabs;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] persons =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = persons[0];
            M = persons[1];

            deudjabs = new HashSet<>();

            IntStream.range(0, N)
                    .forEach(idx -> throwingRunnableWrapper(() -> deudjabs.add(br.readLine())));

            StringBuilder sb = new StringBuilder();

            List<String> deudbojabs = IntStream.range(0, M)
                    .mapToObj(idx -> throwingSupplierWrapper(() -> br.readLine()))
                    .filter(deudjabs::contains).sorted().collect(Collectors.toList());

            sb.append(deudbojabs.size()).append("\n");
            deudbojabs.forEach(deudbojab -> sb.append(deudbojab).append("\n"));
            sb.deleteCharAt(sb.length() - 1);

            System.out.print(sb);
        }
    }

    @FunctionalInterface
    public interface ThrowingRunnable<E extends Exception> {
        void run() throws E;
    }

    static void throwingRunnableWrapper(ThrowingRunnable<Exception> throwingRunnable) {
        try {
            throwingRunnable.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    public interface ThrowingSupplier<T, E extends Exception> {
        T get() throws E;
    }

    static <T> T throwingSupplierWrapper(ThrowingSupplier<T, Exception> throwingSupplier) {
        try {
            return throwingSupplier.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
