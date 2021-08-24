package baekjoon.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11866 {
  public static void main(String[] argv) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine().trim();
    String[] tokens = input.split(" ");

    int N = Integer.parseInt(tokens[0]);
    int K = Integer.parseInt(tokens[1]);
    CustomQueue queue = new CustomQueue();
    StringBuffer sb = new StringBuffer();

    for (int i = 1; i <= N; i++) {
      queue.push(i);
    }

    sb.append("<");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K - 1; j++) {
        queue.push(queue.pop());
      }
      sb.append(queue.pop() + ", ");
    }

    // 마지막에 붙은 콤마와 공백 제거
    sb.delete(sb.length() - 2, sb.length());
    sb.append(">");

    bw.write(sb.toString());

    br.close();
    bw.close();
  }

  static class CustomQueue {
    private Node front;
    private Node rear;
    private int numOfData;

    public void push(int data) {
      Node newNode = new Node(data);
      numOfData++;

      if (front == null) {
        front = newNode;
        rear = newNode;
        return;
      }

      rear.setNextNode(newNode);
      rear = newNode;
    }

    public int pop() {
      int data;

      if (front != null) {
        data = front.getData();
        front = front.getNextNode();
        numOfData--;
      } else {
        data = -1;
        numOfData = 0;
      }

      return data;
    }

    public int size() {
      return this.numOfData;
    }

    public int empty() {
      return size() == 0 ? 1 : 0;
    }
  }

  static class Node {
    private int data;
    private Node nextNode;
    private Node prevNode;

    public Node() {
      data = -1;
    }

    public Node(int data) {
      this.data = data;
    }

    public int getData() {
      return this.data;
    }

    public void setNextNode(Node nextNode) {
      this.nextNode = nextNode;
    }

    public Node getNextNode() {
      return this.nextNode;
    }

    public void setPrevNode(Node prevNode) {
      this.prevNode = prevNode;
    }

    public Node getPrevNode() {
      return this.prevNode;
    }
  }
}
