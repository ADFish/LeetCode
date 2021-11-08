package round.first.binarySearchSortedArray;

/**
 * Suppose a sorted round.first.array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the round.first.array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the round.first.array.
 *
 * Example
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 */

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        int[] A = {4, 5 ,1, 2 ,3};
        System.out.println(search(A, 4));
    }

    /**
     * @param A: an integer rotated sorted round.first.array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public static int search(int[] A, int target) {
        if(A.length == 0 || A == null ){
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] == target){
                return mid;
            }

            if(A[mid] < A[start]){
                if(A[mid] < target && A[end] >= target){ // Here $=$ is needed!
                    start = mid;
                }else {
                    end = mid;
                }
            }else{
                if(A[mid] > target && A[start] <= target){// Here $=$ is needed!
                    end = mid;
                }else {
                    start = mid;
                }
            }

        }// End while loop

        if(A[start] == target){
            return start;
        }else if(A[end] == target){
            return end;
        }else {
            return -1;
        }
    }

}
