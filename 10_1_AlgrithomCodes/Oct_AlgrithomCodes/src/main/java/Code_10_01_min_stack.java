import java.util.Deque;
import java.util.LinkedList;

public class Code_10_01_min_stack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public Code_10_01_min_stack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
