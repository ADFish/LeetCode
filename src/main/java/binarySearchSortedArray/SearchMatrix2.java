package binarySearchSortedArray;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 * <p>
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * Integers in each column are sorted from up to bottom.
 * No duplicate integers in each row or column.
 * <p>
 * Example
 * Consider the following matrix:
 * <p>
 * [
 * [1, 3, 5, 7],
 * [2, 4, 7, 8],
 * [3, 5, 9, 10]
 * ]
 * Given target = 3, return 2.
 * <p>
 * Challenge
 * O(m+n) time and O(1) extra space
 *
 * @see <a href="https://www.lintcode.com/problem/search-a-2d-matrix-ii/description">Original problem</a>
 */

/**
 * Hint: Search from the bottom-left corner rather than the top-left corner
 */
public class SearchMatrix2 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {2, 4, 6, 8}, {3, 5, 9, 10}};
        int target = 3;
        int result = searchMatrix(matrix, target);
        System.out.println(result);
    }

    public static int searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null){
            return 0;
        }
        int rowSize = matrix.length - 1;
        int colSize = matrix[0].length - 1;
        int row = rowSize;
        int col = 0;
        int count = 0;

        while (row >= 0 && col <= colSize) {
            if (matrix[row][col] == target) {
                count = count + 1;
                row = row - 1;
                col = col + 1;
            }else if (matrix[row][col] > target){
                row = row - 1;
            }else{
                col = col + 1;
            }
        }// End loop

        return count;
    }


}
