/**
 * Description
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.
 * <p>
 * Example
 * [1,3,5,6], 5 → 2
 * <p>
 * [1,3,5,6], 2 → 1
 * <p>
 * [1,3,5,6], 7 → 4
 * <p>
 * [1,3,5,6], 0 → 0
 *
 * @see <a href="https://www.lintcode.com/problem/search-insert-position/description">Original Question</a>
 */
public class SearchInseart {
    public static void main(String[] args) {
        int[] A = {1,3,5,6};
        int target = 0;
        int result = searchInsert(A, target);
        System.out.println(result);


    }

    public static int searchInsert(int[] A, int target) {
        int begin = 0;
        int end = A.length - 1;
        int mid;
        if(A.length == 0){
            return 0;
        }
        if (A[end] < target) {
            return end + 1;
        }
        if (A[begin] > target) {
            return 0;
        }

        while (begin + 1 < end) {
            mid = begin + (end - begin) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                begin = mid;
            }
            if (A[mid] > target) {
                end = mid;
            }
        }// End loop


        if (A[end] == target) {
            return end;
        }else if (A[begin] == target) {
            return begin;
        }else{
            return begin + 1;
        }
    }
}
