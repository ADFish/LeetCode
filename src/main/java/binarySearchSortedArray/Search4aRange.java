package binarySearchSortedArray;

import java.util.Arrays;

/**
 * Description
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p>
 * Challenge
 * O(log n) time.
 *
 * @see <a href="https://www.lintcode.com/problem/search-for-a-range/description">Original Question</a>
 */

public class Search4aRange {

  public static void main(String[] args) {
    int[] A = {5, 7, 7, 8, 8, 10};
    int target = 8;
    int[] result = searchRange(A, target);
    System.out.println(Arrays.toString(result));
  }

  /**
   * @param A:      an integer sorted array
   * @param target: an integer to be inserted
   * @return: a list of length 2, [index1, index2]
   */
  public static int[] searchRange(int[] A, int target) {

    if (A.length == 0) {
      return new int[]{-1, -1};
    }

    int start = 0;
    int end = A.length - 1;
    int mid;
    int[] result = new int[2];

    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] == target) {
        end = mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }// End loop

    if (A[start] == target) {
      result[0] = start;
    } else if (A[end] == target) {
      result[0] = end;
    } else {
      return new int[]{-1, -1};
    }

    start = 0;
    end = A.length - 1;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] == target) {
        start = mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }// End loop

    if (A[end] == target) {
      result[1] = end;
    } else if (A[start] == target) {
      result[1] = start;
    } else {
      return new int[]{-1, -1};
    }

    return result;
  }

}
