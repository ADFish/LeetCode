package binarySearch;

// https://leetcode.com/problems/search-a-2d-matrix/

public class searcha2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 30;
        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        // Search by row

        int start1 = 0;
        int end1 = row;
        int mid1;

        while (start1 + 1 < end1) {
            mid1 = start1 + (end1 - start1) / 2;
            if (matrix[mid1][0] == target) {
                return true;
            }
            if (matrix[mid1][0] < target) {
                start1 = mid1;
            }
            if (matrix[mid1][0] > target) {
                end1 = mid1;
            }
        }

        if (matrix[start1][0] == target) {
            return true;
        }

        if (matrix[end1][0] == target) {
            return true;
        }

        int rowNumber;
        if (matrix[end1][0] < target) {
            rowNumber = end1;
        } else {
            rowNumber = start1;
        }

        // Search by column
        int start2 = 0;
        int end2 = col;
        int mid2;

        while (start2 + 1 < end2) {
            mid2 = start2 + (end2 - start2) / 2;
            if (matrix[rowNumber][mid2] == target) {
                return true;
            }

            if (matrix[rowNumber][mid2] < target) {
                start2 = mid2;
            }

            if (matrix[rowNumber][mid2] > target) {
                end2 = mid2;
            }
        }

        if (matrix[rowNumber][start2] == target) {
            return true;
        }

        if (matrix[rowNumber][end2] == target) {
            return true;
        }

        return false;

    }
}
