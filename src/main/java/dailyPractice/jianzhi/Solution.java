package dailyPractice.jianzhi;

import java.util.*;

public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    traverseIsland(grid, row, col);
                    res++;
                }
            }
        }

        return res;
    }

    private void traverseIsland(char[][] grid, int row, int col) {
        if(!inArea(grid,row, col)) {
            return;
        }

        if(grid[row][col] != '1') return;

        grid[row][col] = '2';

        traverseIsland(grid, row + 1, col);
        traverseIsland(grid, row - 1, col);
        traverseIsland(grid, row, col + 1);
        traverseIsland(grid, row, col - 1);

    }

    private boolean inArea(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) return true;
        return false;
    }
}
