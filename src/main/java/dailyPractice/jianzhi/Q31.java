package dailyPractice.jianzhi;

import java.util.Stack;

public class Q31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.add(pushed[i]);
            while (!stack.isEmpty() && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
        }

        return (j == popped.length) && stack.isEmpty();
    }
}
