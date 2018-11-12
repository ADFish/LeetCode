/**
 * Given a set of distinct integers, return all possible subsets.
 * <p>
 * Example
 * If S = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    List<List<Integer>> result = subsets(nums);
    System.out.println(result);

  }

  public static List<List<Integer>> subsets(int[] nums) {
    // write your code here
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int pos = 0;

    if (nums.length == 0) {
      result.add(new ArrayList<>(subset));
      return result;
    }
    Arrays.sort(nums);
    subsetsHelper(nums, subset, pos, result);

    return result;
  }

  private static void subsetsHelper(int[] nums, List<Integer> subset, int pos, List<List<Integer>> result) {

    result.add(new ArrayList<>(subset));

    for (int i = pos; i < nums.length; i++) {
      subset.add(nums[i]);
      subsetsHelper(nums, subset, i + 1, result);
      subset.remove(subset.size() - 1);
    }

  }
}
