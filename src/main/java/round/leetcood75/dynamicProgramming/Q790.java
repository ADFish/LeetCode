package round.leetcood75.dynamicProgramming;

public class Q790 {
    public int numTilings(int n) {
        int mod = (int)1e9 + 7;

        int[][] f = new int[n][4];
        f[0][0] = 1;
        f[0][3] = 1;

        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][3]  % mod;
            f[i][1] = (f[i - 1][0] + f[i - 1][2]) % mod;
            f[i][2] = (f[i - 1][0] + f[i - 1][1]) % mod;
            f[i][3] = ((((f[i - 1][0] + f[i - 1][1]) % mod + f[i - 1][2]))% mod + f[i - 1][3]) % mod;
        }

        return f[n-1][3] % mod;

    }
}
