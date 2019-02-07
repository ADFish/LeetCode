package linkedList;

//https://www.lintcode.com/problem/sort-list/description
public class SortList {
  /**
   * @param head: The head of linked list.
   * @return: You should return the head of the sorted linked list, using constant space complexity.
   */
  public ListNode mergeSortList(ListNode head) {
    // write your code here
    if (head == null || head.next == null) {
      return head;
    }

    ListNode middle = findMiddle(head);

    ListNode right = mergeSortList(middle.next);
    middle.next = null;
    ListNode left = mergeSortList(head);

    return merge(left, right);
  }

  private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode quick = head.next;
    while (quick != null && quick.next != null) {
      slow = slow.next;
      quick = quick.next.next;
    }

    return slow;
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        head.next = left;
        left = left.next;
      } else {
        head.next = right;
        right = right.next;
      }
      head = head.next;
    }

    if (left != null) {
      head.next = left;
    } else {
      head.next = right;
    }

    return dummy.next;
  }


  //Quick Sort

  /**
   * @param head: The head of linked list.
   * @return: You should return the head of the sorted linked list, using constant space complexity.
   */
  public ListNode quickSortList(ListNode head) {
    // write your code here
    if (head == null || head.next == null) {
      return head;
    }
    int pivot = head.val;
    ListNode smallPartion = new ListNode(0);
    ListNode largePartion = new ListNode(0);
    ListNode pivotNode = new ListNode(0);
    ListNode smallHead = smallPartion;
    ListNode largeHead = largePartion;
    ListNode pivotHead = pivotNode;

    while (head != null) {
      if (head.val < pivot) {
        smallHead.next = head;
        smallHead = smallHead.next;
      } else if (head.val > pivot) {
        largeHead.next = head;
        largeHead = largeHead.next;
      } else {
        pivotHead.next = head;
        pivotHead = pivotHead.next;
      }
      head = head.next;
    }

    smallHead.next = null;
    largeHead.next = null;
    pivotHead.next = null;

    ListNode small = quickSortList(smallPartion.next);
    ListNode large = quickSortList(largePartion.next);

    return merge(small, pivotNode.next, large);
  }

  private ListNode merge(ListNode small, ListNode pivot, ListNode large) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    head.next = small;
    head = getTail(head);
    head.next = pivot;
    head = getTail(head);
    head.next = large;
    head = getTail(head);

    return dummy.next;
  }

  private ListNode getTail(ListNode head) {
    if (head == null) {
      return null;
    }

    while (head.next != null) {
      head = head.next;
    }

    return head;
  }
}
