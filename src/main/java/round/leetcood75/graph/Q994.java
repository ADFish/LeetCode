package round.leetcood75.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q994 {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;

        Deque<int[]> queue = new ArrayDeque<>();

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] == 2) {
                    queue.offer(new int[]{y, x});
                }

                if(grid[y][x] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curY = cur[0];
                int curX = cur[1];
                if(inGrid(grid, curY + 1, curX) && grid[curY + 1][curX] == 1) {
                    queue.offer(new int[]{curY + 1, curX});
                    grid[curY + 1][curX] = 2;
                    fresh--;
                }
                if(inGrid(grid, curY, curX + 1) && grid[curY][curX + 1] == 1) {
                    queue.offer(new int[]{curY, curX + 1});
                    grid[curY][curX + 1] = 2;
                    fresh--;
                }
                if(inGrid(grid, curY - 1, curX) && grid[curY - 1][curX] == 1) {
                    queue.offer(new int[]{curY - 1, curX});
                    grid[curY - 1][curX] = 2;
                    fresh--;
                }
                if(inGrid(grid, curY, curX - 1) && grid[curY][curX - 1] == 1) {
                    queue.offer(new int[]{curY, curX - 1});
                    grid[curY][curX - 1] = 2;
                    fresh--;
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    private boolean inGrid(int[][] grid, int y, int x) {
        int m = grid.length;
        int n = grid[0].length;
        return y >= 0 && y < m && x >= 0 && x < n;
    }
}
