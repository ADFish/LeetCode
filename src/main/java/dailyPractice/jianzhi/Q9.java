package dailyPractice.jianzhi;

import java.util.Stack;

public class Q9 {
}

class CQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (stack2.isEmpty() && !stack1.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }
        return -1;
    }
}
