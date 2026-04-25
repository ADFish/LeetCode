package round.leetcood75;

import java.util.Arrays;

public class Q435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int ans = 0;
        int right = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] >= right) {
                right = interval[1];
                ans++;
            }
        }

        return intervals.length - ans;
    }
}
