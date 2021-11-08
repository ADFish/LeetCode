package round.first.linkedList;
//https://www.lintcode.com/problem/linked-list-cycle/description
public class hasCycle {

  /**
   * @param head: The first node of linked list.
   * @return: True if it has a cycle, or false
   */
  public boolean hasCycle(ListNode head) {
    // write your code here
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != slow) {
      if(fast == null || fast.next == null) {
        return false;
      }

      slow = slow.next;
      fast = fast.next.next;
    }

    return true;
  }
}
