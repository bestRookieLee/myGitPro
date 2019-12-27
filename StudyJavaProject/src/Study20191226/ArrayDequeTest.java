package Study20191226;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ArrayDequeTest {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(12);
        stack.push(16);
        int tail = stack.pop();//尾部出栈
        tail = stack.peek();
        System.out.println(tail);
        System.out.println("========================================");
        Deque<Integer> integerDeque = new LinkedList<>();
        integerDeque.push(123);
        integerDeque.push(666);
        integerDeque.pop();
        System.out.println(integerDeque.peek());
    }
}
