package dailyPractice.jianzhi;

public class Q4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int col = 0;
        int row = matrix.length - 1;

        while (col < colSize & row >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                col++;
            }
            if (matrix[row][col] > target) {
                row--;
            }
        }
        return false;
    }
}
