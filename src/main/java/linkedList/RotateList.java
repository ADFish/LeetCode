package linkedList;
//https://www.lintcode.com/problem/rotate-list/description
public class RotateList {

  /**
   * @param head: the List
   * @param k: rotate to the right k places
   * @return: the list after rotation
   */
  public ListNode rotateRight(ListNode head, int k) {
    // write your code here
    if (head == null || head.next == null) {
      return head;
    }

    int length = getListLength(head);

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    int n = k % length;
    ListNode slow = dummy;
    ListNode fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    ListNode temp = slow.next;
    slow.next = null;
    slow = temp;

    dummy.next = slow;
    ListNode tail = dummy;
    while (tail.next != null) {
      tail = tail.next;
    }

    tail.next = head;

    return dummy.next;
  }

  private int getListLength(ListNode head){
    if(head == null) {
      return 0;
    }

    int length = 0;
    while (head != null) {
      head = head.next;
      length++;
    }

    return length;
  }
}
