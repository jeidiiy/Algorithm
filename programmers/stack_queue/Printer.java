package programmers.stack_queue;

import java.util.*;

public class Printer {

  class Document {
    private int priority;
    private int location;

    public Document(int priority, int location) {
      this.priority = priority;
      this.location = location;
    }
  }

  public int solution(int[] priorities, int location) {
    
    LinkedList<Document> q = new LinkedList<>();
    int cnt = 0;

    for (int i = 0; i < priorities.length; i++) {
      q.offer(new Document(priorities[i], i));
    }

    while (!q.isEmpty()) {
      boolean flag = false;
      Document J = q.poll();

      for (Document d : q) {
        if (J.priority < d.priority) {
          q.offer(J);
          flag = true;
          break;
        }
      }

      if (!flag) {
        cnt++;
        if (J.location == location) {
          break;
        }
      }
    }

    return cnt;
  }
}
