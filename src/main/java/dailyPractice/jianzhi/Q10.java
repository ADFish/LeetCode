package dailyPractice.jianzhi;

public class Q10 {
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n == 0 || n == 1) return n;
        int f1 = 0, f2 = 1, f3 = f1 + f2;
        for (int i = 2; i < n; i++) {
            f1 = f2;
            f2 = f3;
            f3 = (f1 + f2) % MOD;
        }
        return f3;
    }

    public int numWays(int n) {
        final int MOD = 1000000007;
        if (n == 0 || n == 1) return 1;
        int f1 = 1;
        int f2 = 1;
        int f3 = f1 + f2;
        for (int i = 2; i < n; i++) {
            f1 = f2;
            f2 = f3;
            f3 = (f1 + f2) % MOD;
        }

        return f3;
    }
}

