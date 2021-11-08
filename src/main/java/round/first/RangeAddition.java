package round.first;

/**
 * Assume you have an round.first.array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * Return the modified round.first.array after all k operations were executed.
 * <p>
 * Example
 * Given:
 * length = 5,
 * updates =
 * [
 * [1,  3,  2],
 * [2,  4,  3],
 * [0,  2, -2]
 * ]
 * return [-2, 0, 3, 5, 3]
 * <p>
 * Explanation:
 * Initial state:
 * [ 0, 0, 0, 0, 0 ]
 * After applying operation [1, 3, 2]:
 * [ 0, 2, 2, 2, 0 ]
 * After applying operation [2, 4, 3]:
 * [ 0, 2, 5, 5, 3 ]
 * After applying operation [0, 2, -2]:
 * [-2, 0, 3, 5, 3 ]
 *
 * @see <a href="https://www.lintcode.com/problem/range-addition/description">Origin quesion</a>
 */
public class RangeAddition {

  public static void main(String[] args) {
    int length = 5;
    int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
    int[] result = getModifiedArray(length, updates);
    System.out.println(result);

  }

  /**
   * @param length:  the length of the round.first.array
   * @param updates: update operations
   * @return: the modified round.first.array after all k operations were executed
   */

  public static int[] getModifiedArray(int length, int[][] updates) {
    // Write your code here
    int[] result = new int[length];
    for (int[] i : updates) {
      int startIndex = i[0];
      int endIndex = i[1];
      int inc = i[2];
      for (int j = startIndex; j <= endIndex; j++) {
        result[j] = result[j] + inc;
      }
    }
    return result;
  }

  public int[] betterGetModifiedArray(int length, int[][] updates) {
    // Write your code here
    int[] res = new int[length];
    int[] nums = new int[length + 1];
    for (int i = 0; i < updates.length; i++) {
      nums[updates[i][0]] += updates[i][2];
      nums[updates[i][1] + 1] -= updates[i][2];
    }
    int sum = 0;
    for (int i = 0; i < length; i++) {
      sum += nums[i];
      res[i] = sum;
    }
    return res;
  }

}

