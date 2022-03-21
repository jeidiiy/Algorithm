package datastructure;

import java.util.Stack;

public class QueueWithTwoStack<T> {

    Stack<T> stackForEnqueuing = new Stack<>();
    Stack<T> stackForDequeuing = new Stack<>();

    public boolean enqueue(T element) {
        return stackForEnqueuing.add(element);
    }

    public T dequeue() {
        if (stackForDequeuing.isEmpty()) {
            while (!stackForEnqueuing.isEmpty()) {
                stackForDequeuing.push(stackForEnqueuing.pop());
            }
        }
        return stackForDequeuing.pop();
    }

    public int size() {
        return stackForEnqueuing.size() + stackForDequeuing.size();
    }

    public boolean isEmpty() {
        return stackForEnqueuing.isEmpty() && stackForDequeuing.isEmpty();
    }

    public T peek() {
        return stackForDequeuing.isEmpty() ? stackForEnqueuing.firstElement() : stackForDequeuing.lastElement();
    }

    public String dump() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!isStackForDequeuingEmpty()) {
            for (int i = stackForDequeuing.size() - 1; i >= 0; i--) {
                sb.append(stackForDequeuing.get(i));
                if (i > 0)
                    sb.append(", ");
            }
            if (!stackForEnqueuing.isEmpty())
                sb.append(", ");
        }
        if (!stackForEnqueuing.isEmpty()) {
            for (int i = 0; i < stackForEnqueuing.size(); i++) {
                sb.append(stackForEnqueuing.get(i));
                if (i < stackForEnqueuing.size() - 1)
                    sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * deque용 스택이 비어있는 상태가 아니라면 inque용 스택을 deque용으로 옮기지 않아야 한다.
     * 그렇지 않으면 원소 간 순서가 유지되지 않기 때문이다.
     * 
     * @return True if StackForDequeuing is empty, else return false
     */
    private boolean isStackForDequeuingEmpty() {
        return stackForDequeuing.isEmpty();
    }

    public static void main(String[] args) {
        QueueWithTwoStack<Integer> queue = new QueueWithTwoStack<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.printf("Current queue's elements: %s\n", queue.dump()); // [1, 2, 3]
        System.out.println("peek: " + queue.peek()); // 1
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.printf("Current queue's elements: %s\n", queue.dump()); // [2, 3, 4, 5]
        System.out.println("peek: " + queue.peek()); // 2
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("peek: " + queue.peek()); // 4
        System.out.println(queue.dequeue());
        System.out.printf("Current queue's elements: %s\n", queue.dump()); // [5]
    }
}