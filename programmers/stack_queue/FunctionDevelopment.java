package programmers.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {

  public int[] solution(int[] progresses, int[] speeds) {
    ArrayList<Integer> res = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < progresses.length; i++) {
      double remain = (100 - progresses[i]) / (double) speeds[i];
      int date = (int) Math.ceil(remain);

      if (!q.isEmpty() && q.peek() < date) {
        res.add(q.size());
        q.clear();
      }

      q.offer(date);
    }

    res.add(q.size());

    int[] answer = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      answer[i] = res.get(i);
    }

    return answer;
  }
  
}