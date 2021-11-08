package round.first.linkedList;

public class ReverseLinkedList2 {

  /**
   * @param head: ListNode head is the head of the linked list
   * @param m:    An integer
   * @param n:    An integer
   * @return: The head of the reversed ListNode
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    // write your code here
    if (head == null) {
      return null;
    }
    ListNode nodeM, nodeMprev, nodeN, nodeNpost;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;

    for (int i = 1; i < m; i++) {
      if (head == null) {
        return null;
      }
      head = head.next;
    }
    nodeMprev = head;
    nodeM = head.next;
    nodeN = nodeM;
    nodeNpost = nodeM.next;

    for (int i = m; i < n; i++) {
      if (nodeNpost == null) {
        return null;
      }
      ListNode temp = nodeNpost.next;
      nodeNpost.next = nodeN;
      nodeN = nodeNpost;
      nodeNpost = temp;
    }

    nodeMprev.next = nodeN;
    nodeM.next = nodeNpost;

    return dummy.next;
  }
}
