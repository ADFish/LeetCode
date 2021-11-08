package round.first.linkedList;

//https://www.lintcode.com/problem/reorder-list/description
public class ReorderList {
  /**
   * @param head: The head of linked list.
   * @return: nothing
   */
  public void reorderList(ListNode head) {
    // write your code here
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }

    ListNode middle = findMiddle(head);
    ListNode tail = reverseList(middle.next);
    middle.next = null;

    merge(head, tail);
  }

  private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
    return prev;
  }

  private void merge(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    int index = 0;
    while (head1 != null && head2 != null) {
      if (index % 2 == 0) {
        head.next = head1;
        head1 = head1.next;
      } else {
        head.next = head2;
        head2 = head2.next;
      }
      head = head.next;
      index++;
    }

    if (head1 != null) {
      head.next = head1;
    } else {
      head.next = head2;
    }

    head1 = dummy.next;
  }
}
