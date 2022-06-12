package dailyPractice.jianzhi;


public class Q18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        head = dummy;
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return head.next;
    }

}
