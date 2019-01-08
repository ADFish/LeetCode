package weeklyChallenge;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 *
 * @see <a href="https://www.lintcode.com/problem/maximum-swap/description/">Original Problem</>
 */
public class MaximumSwap {
  public static void main(String[] args) {
    int num = 5656626;
    int result = maximumSwap(num);
    System.out.println(result);

  }

  public static int maximumSwap(int num) {
    // Write your code here
    String string = Integer.toString(num);
    char[] array = string.toCharArray();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < array.length ; ++i) {
      Integer n = array[i] - 48;
      while(!stack.isEmpty()&& array[stack.peek()] - 48 < n){
        stack.pop();
      }// End while loop
      stack.push(i);
    }// End loop for finding the the index

    if(stack.size() == array.length){
      return num;
    }

    int j = 0;
    int k = 0;
    int[] maxIndex = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
      maxIndex[i] = stack.peek();
      if(array[i] < array[stack.peek()]){
        j = i;
        k = stack.peek();
      }
      stack.pop();
    }

    for (int i = 0; i < maxIndex.length; i++) {
      if(array[maxIndex[i]] == array[k]){
        k = maxIndex[i];
      }

    }

    swap(array, j, k);
    //System.out.println(array.toString());
    return Integer.parseInt(new String(array));
  }

  public static void swap(char[] array, int j, int k){
    char temp = array[j];
    array[j] = array[k];
    array[k] = temp;
  }
}
