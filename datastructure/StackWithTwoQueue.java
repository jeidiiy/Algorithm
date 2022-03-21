package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueue<T> {

    Queue<T> mainQueue = new LinkedList<>();
    Queue<T> subQueue = new LinkedList<>();

    public void push(T element) {
        if (mainQueue.isEmpty()) {
            mainQueue.add(element);
        } else {
            /**
             * 맨 마지막으로 들어온 원소만 남을 때까지 서브큐로 모두 옮긴다.
             * 그 다음 서브큐의 원소들을 다시 메인큐에 넣는다.
             */
            mainQueue.add(element);
            while (mainQueue.size() != 1) {
                subQueue.add(pop());
            }
            while (!subQueue.isEmpty()) {
                mainQueue.add(subQueue.poll());
            }
        }
    }

    public T pop() {
        return mainQueue.poll();
    }

    public T peek() {
        return mainQueue.peek();
    }

    public int size() {
        return mainQueue.size();
    }

    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = mainQueue.size();
        for (int i = 0; i < size; i++) {
            T element = pop();
            sb.append(element);
            mainQueue.add(element);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackWithTwoQueue<Integer> stack = new StackWithTwoQueue<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Current stack's status: " + stack); // [1, 2, 3]
        System.out.println("peek: " + stack.peek()); // 3
        System.out.println("pop: " + stack.pop()); // 3

        stack.push(4);
        stack.push(5);

        System.out.println("Current stack's status: " + stack); // [1, 2, 4, 5]
        System.out.println("peek: " + stack.peek()); // 5
        System.out.println("pop: " + stack.pop()); // 5
        System.out.println("pop: " + stack.pop()); // 4
        System.out.println("peek: " + stack.peek()); // 2
        System.out.println("pop: " + stack.pop()); // 2
        System.out.println("Current stack's status: " + stack); // [1]
    }
}
