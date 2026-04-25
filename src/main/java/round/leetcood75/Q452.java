package round.leetcood75;

import java.util.Arrays;

public class Q452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) ->  Integer.compare(a[1], b[1]));

        int count = 1;
        int right = points[0][1];

        for (int[] point : points) {
            if (point[0] > right) {
                right = point[1];
                count++;
            }
        }
        return count;
    }
}
