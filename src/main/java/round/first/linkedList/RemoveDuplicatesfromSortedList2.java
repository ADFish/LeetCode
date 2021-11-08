package round.first.linkedList;

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

    while(head.next != null && head.next.next != null){
      if(head.next.val == head.next.next.val){
        int temp = head.next.val;
        while(head.next != null && head.next.val == temp){
          head.next = head.next.next;
        }
      }else{
        head = head.next;
      }
    }
    return dummy.next;

  }
}
