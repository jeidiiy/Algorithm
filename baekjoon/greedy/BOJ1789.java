package greedy;

import java.io.*;

class BOJ1789 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long num = Long.parseLong(br.readLine());
    long sum = 1;
    long count = 1;

    while (sum < num) {
      count += 1;
      sum += count;
    }

    if (sum > num) {
      count -= 1;
    }
    bw.write(String.valueOf(count));

    br.close();
    bw.close();
  }
}