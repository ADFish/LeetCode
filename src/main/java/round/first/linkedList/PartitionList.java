package round.first.linkedList;

//https://www.lintcode.com/problem/partition-list/description
// idea: 双指针
public class PartitionList {
  /**
   * @param head: The first node of linked list
   * @param x: An integer
   * @return: A ListNode
   */
  public ListNode partition(ListNode head, int x) {
    // write your code here
    if (head == null) {
      return null;
    }

    ListNode leftPart = new ListNode(0);
    ListNode rightPart = new ListNode(0);
    ListNode left = leftPart;
    ListNode right = rightPart;

    while (head != null) {
      if (head.val < x) {
        left.next = head;
        left = head;
      } else {
        right.next = head;
        right = head;
      }
      head = head.next;
    }

    right.next = null;// Easy to get this
    left.next = rightPart.next;
    return leftPart.next;
  }
}
