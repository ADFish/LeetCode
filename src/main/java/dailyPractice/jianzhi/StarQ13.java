package dailyPractice.jianzhi;

public class StarQ13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, 0, 0, k, visited);
    }

    public int dfs(int m, int n, int i, int j, int k, boolean[][] visited) {
        if (sumDigit(i, j) > k || i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(m, n, i + 1, j, k, visited) + dfs(m, n, i, j + 1, k, visited) + dfs(m, n, i - 1, j, k, visited) + dfs(m, n, i, j - 1, k, visited);
    }

    // 数位之和计算：
    int sumDigit(int x, int y) {
        int s = 0;
        while (x != 0) {
            s += x % 10;
            x = x / 10;
        }
        while (y != 0) {
            s += y % 10;
            y = y / 10;
        }
        return s;
    }
}
