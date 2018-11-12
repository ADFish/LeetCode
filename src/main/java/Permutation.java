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
    boolean[] visited = new boolean[nums.length];
    for (boolean i: visited) {
      System.out.println(i);
    }

  }

  /*
   * @param nums: A list of integers.
   * @return: A list of permutations.
   */
  public static List<List<Integer>> permute(int[] nums) {
    // write your code here
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> permutation = new ArrayList<>();

    Arrays.sort(nums);
    return result;
  }

  public static void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> permutation,int pos) {

    for (int i = 0; i < nums.length - 1; i++) {
      permutation.add(nums[i]);
      permuteHelper(nums, result, permutation, i + 1);
      if (permutation.size() == nums.length) {
        result.add(new ArrayList<>(permutation));
      }
      permutation.remove(permutation.size() - 1);


    }

  }

}
