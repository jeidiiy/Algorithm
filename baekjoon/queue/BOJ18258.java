package baekjoon.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ18258 {
  public static void main(String[] argv) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int taskcase = Integer.parseInt(br.readLine().trim());
    CustomQueue queue = new CustomQueue();

    for (int i = 0; i < taskcase; i++) {
      String[] tokens = br.readLine().split(" ");

      switch (tokens[0]) {
        case "push":
          queue.push(Integer.parseInt(tokens[1]));
          break;
        case "pop":
          int popedData = queue.pop();
          bw.write(popedData + "\n");
          break;
        case "size":
          bw.write(queue.size() + "\n");
          break;
        case "empty":
          bw.write(queue.empty() + "\n");
          break;
        case "front":
          int frontData = queue.front();
          bw.write(frontData + "\n");
          break;
        case "back":
          int backData = queue.back();
          bw.write(backData + "\n");
          break;
        default:
          continue;
      }
    }

    br.close();
    bw.close();
  }
}

class CustomQueue {
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

  public int front() {
    return size() == 0 ? -1 : front.getData();
  }

  public int back() {
    return size() == 0 ? -1 : rear.getData();
  }
}

class Node {
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