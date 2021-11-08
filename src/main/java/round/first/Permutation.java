package round.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers, return all possible permutations.
 * <p>
 * Example
 * For nums = [1,2,3], the permutations are:
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @see <a href="https://www.lintcode.com/problem/permutations/description">Origin question</a>
 */
public class Permutation {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> result = permute(nums);
    System.out.println(result);
  }

  /*
   * @param nums: A list of integers.
   * @return: A list of permutations.
   */
  public static List<List<Integer>> permute(int[] nums) {
    // write your code here
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> permutation = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];

    if (nums == null) {
      return result;
    }

    Arrays.sort(nums);
    permuteHelper(nums, result, permutation, visited);
    return result;
  }

  public static void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> permutation, boolean[] visited) {

    if (permutation.size() == nums.length){
      result.add(new ArrayList<>(permutation));
    }

    for (int i = 0; i < nums.length ; i++) {
      if (visited[i] == false){
        permutation.add(nums[i]);
        visited[i] = true;
        permuteHelper(nums, result, permutation, visited);
        visited[i] = false;
        permutation.remove(permutation.size() - 1);
      }

    }// End loop for
  }

}
