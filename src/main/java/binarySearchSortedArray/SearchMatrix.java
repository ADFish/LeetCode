package binarySearchSortedArray;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * <p>
 * Challenge
 * O(log(n) + log(m)) time
 *
 * @see <a href="https://www.lintcode.com/problem/search-a-2d-matrix/description">Original problem</>
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0){
            return false;
        }
        int begin1 = 0;
        int end1 = matrix.length - 1;
        int dim = matrix[0].length - 1;
        int mid;
        int rowNumber;

        if(matrix[begin1][0] > target || matrix[end1][dim] < target){
            return false;
        }

        while (begin1 + 1 < end1){
            mid = begin1 + (end1 - begin1) / 2;
            if(matrix[mid][0] == target){
                return true;
            }
            if(matrix[mid][0] < target){
                begin1 = mid;
            }
            if(matrix[mid][0] > target){
                end1 = mid;
            }
        }

        if(matrix[end1][0] == target){
            return true;
        }
        if(matrix[begin1][0] == target){
            return true;
        }
        if(matrix[end1][0] < target){
            rowNumber = end1;
        }else {
            rowNumber = begin1;
        }

        int[] row = matrix[rowNumber];
        int begin2 = 0;
        int end2 = dim;
        int mid2;

        while (begin2 + 1 < end2){
            mid2 = begin2 + (end2 - begin2)/2;
            if(row[mid2] == target){
                return true;
            }
            if(row[mid2] < target){
                begin2 = mid2;
            }
            if(row[mid2] > target){
                end2 = mid2;
            }
        }

        if(row[begin2] == target || row[end2] == target){
            return true;
        }else {
            return false;
        }

    }
}
