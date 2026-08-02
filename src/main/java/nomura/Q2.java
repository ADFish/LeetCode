package nomura;

import java.util.Arrays;

public class Q2 {
    public int solution(int[] A) {
        // Implement your solution here
        int m = A.length;
        int[] pair = new int[m - 1];

        int n = 3;

        if(m < 4) n = 1;
        if(m < 6) n = 2;

        for(int i = 0; i < m - 1; i++) {
            pair[i] = A[i] + A[i + 1];
        }

        Arrays.sort(pair);

        int[][] dp = new int[n + 1][m];

        for(int i = 1; i <= n; i++) {
            for(int j = 2; j < m; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 2] + pair[i]);
            }
        }

        return dp[n][m - 1];
    }
}
