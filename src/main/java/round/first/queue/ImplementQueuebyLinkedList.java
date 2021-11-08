package round.first.queue;

public class ImplementQueuebyLinkedList {

  LLNode front, rear;
  public ImplementQueuebyLinkedList(){
    this.front = this.rear = null;
  }
  /*
   * @param item: An integer
   * @return: nothing
   */
  public void enqueue(int item) {
    // write your code here
    LLNode temp = new LLNode(item);
    if(this.rear == null){
      this.front = this.rear = temp;
      return;
    }
    this.rear.next = temp;
    this.rear = temp;
  }

  /*
   * @return: An integer
   */
  public int dequeue() {
    // write your code here
    if(this.front == null){
      return Integer.MIN_VALUE;
    }

    LLNode temp = this.front;
    this.front = this.front.next;
    //Don't forget this:
    if(this.front == null){
      this.rear = null;
    }
    return temp.val;
  }
}

class LLNode{
  int val;
  LLNode next;
  public LLNode(int val){
    this.val = val;
    this.next = null;
  }
}





