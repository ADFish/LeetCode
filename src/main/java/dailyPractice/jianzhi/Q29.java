package dailyPractice.jianzhi;

import java.security.Key;
import java.util.ArrayList;

public class Q29 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Q29 q29 = new Q29();
        int[] res = q29.spiralOrder(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        int i = 0, j = 0, t = 0, l = 0, b = matrix.length - 1, r = matrix[0].length - 1;
        ArrayList res = new ArrayList<Integer>();
        int[] result = new int[matrix.length * matrix[0].length];

        while (b >= t && r >= l) {
            //left -> right
            while (j <= r) {
                res.add(matrix[t][j]);
                j++;
            }
            j--;
            t++;
            i++;

            //top -> bottom
            while (i <= b) {
                res.add(matrix[i][r]);
                i++;
            }
            i--;
            r--;
            j--;

            //right -> left
            while (j >= l) {
                res.add(matrix[b][j]);
                j--;
            }
            j++;
            b--;
            i--;

            //bottom -> top
            while (i >= t) {
                res.add(matrix[i][l]);
                i--;
            }
            i++;
            l++;
            j++;
        }

        for (int k = 0; k < res.size() ; k++) {
            result[k] = Integer.parseInt(res.get(k).toString());
        }

        return result;
    }
}
