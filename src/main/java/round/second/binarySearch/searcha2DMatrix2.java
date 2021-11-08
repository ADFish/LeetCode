package round.second.binarySearch;

public class searcha2DMatrix2 {

    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int[][] matrix1 = {{-5}};
        int target = -10;
        System.out.println(searchMatrix(matrix1, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 ){
            return false;
        }

        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int r = matrix.length - 1;
        int c = matrix[0].length - 1;


        int point_r = r;
        int point_c = 0;

        while (point_r >= 0 && point_c <= c) {

            if(matrix[point_r][point_c] == target) {
                return true;
            }

            if(matrix[point_r][point_c] > target) {
                point_r = point_r - 1;
            } else if(matrix[point_r][point_c] < target) {
                point_c = point_c + 1;
            }

        }

        return false;

    }
}
