package round.first.linkedList;

//https://www.lintcode.com/problem/merge-k-sorted-lists/description

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

  /**
   * @param lists: a list of ListNode
   * @return: The head of one sorted list.
   */
  public ListNode mergeKLists(List<ListNode> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }

    Queue<ListNode> heap = new PriorityQueue<>(lists.size(), listNodeComparator);
    for (int i = 0; i < lists.size(); i++) {
      if (lists.get(i) != null) {
        heap.offer(lists.get(i));
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    while (!heap.isEmpty()) {
      ListNode head = heap.poll();
      tail.next = head;
      tail = tail.next;
      while (head.next != null) {
        heap.offer(head.next);
        head = head.next;
      }
    }

    return dummy.next;
  }

  private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
    @Override
    public int compare(ListNode o1, ListNode o2) {
      return o1.val - o2.val;
    }
  };

  }
