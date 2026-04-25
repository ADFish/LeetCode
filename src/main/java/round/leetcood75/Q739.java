package round.leetcood75;

import java.util.ArrayDeque;

public class Q739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }

            stack.push(i);
        }

        return res;
    }
}
