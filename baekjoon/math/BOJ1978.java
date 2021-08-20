package math;

import java.io.*;

public class BOJ1978 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    String input = br.readLine();
    String[] tokens = input.split(" ");
    int res = 0;

    int[] nums = new int[tokens.length];

    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(tokens[i]);
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 2) {
        res++;
        continue;
      }

      if (nums[i] % 2 == 0)
        continue;

      int count = 0;
      for (int j = 3; j <= nums[i]; j += 2) {
        if (nums[i] % j == 0)
          count++;
      }

      if (count > 1 || count == 0)
        continue;

      res++;
    }

    System.out.println(res);
  }

}
