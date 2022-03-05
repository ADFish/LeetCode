package dailyPractice.jianzhi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Q6 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        Q6 q6 = new Q6();
        int[] result = q6.reversePrint(head);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;

    }

    public int[] reversePrint1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            int[] result = {};
            return result;
        }
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i);
        }
        return result;
    }
}

