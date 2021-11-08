package round.first.linkedList;

//https://www.lintcode.com/problem/reverse-linked-list/description
public class ReverseLinkedList {
  /**
   * @param head: n
   * @return: The new head of reversed linked list.
   */
  public ListNode reverse(ListNode head) {
    // write your code here
    if(head == null || head.next == null){
      return head;
    }

    ListNode prev = null;

    while(head != null){
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }

    return prev;
  }
}
