package priority_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ11279 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    StringBuffer sb = new StringBuffer();

    int taskcase = Integer.parseInt(br.readLine().trim());

    for (int i = 0; i < taskcase; i++) {
      int input = Integer.parseInt(br.readLine().trim());

      if (input == 0) {
        sb.append(pq.isEmpty() ? 0 + "\n" : pq.poll() + "\n");
      } else {
        pq.offer(input);
      }
    }

    bw.write(sb.toString());
    br.close();
    bw.close();
  }
}
