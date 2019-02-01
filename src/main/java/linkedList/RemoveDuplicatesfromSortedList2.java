package linkedList;

public class RemoveDuplicatesfromSortedList2 {
  /**
   * @param head: head is the head of the linked list
   * @return: head of the linked list
   */
  public ListNode deleteDuplicates(ListNode head) {
    // write your code here
    if(head == null || head.next == null){
      return head;
    }
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    head = dummy;
    ListNode prev = head;
    ListNode curt = head.next;



  }
}
