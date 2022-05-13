package dailyPractice.jianzhi;

public class Q14 {

    public int cuttingRope0(int n) {
        int res = 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * cuttingRope0(n - i)));
        }
        return res;
    }

    public int cuttingRope(int n) {
        int[] res = new int[n + 1];
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                res[i] = Math.max(res[i], Math.max(j * res[i - j], j * (i - j)));
            }
        }
        return res[n];
    }

    // Because we used mod, the max function won't work
    public int cuttingRope1(int n) {
        final int MOD = 1000000007;
        int[] res = new int[n + 1];
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                res[i] = Math.max(res[i] % MOD, Math.max(j * res[i - j] % MOD, j * (i - j) % MOD));
            }
        }
        return res[n];
    }

}
