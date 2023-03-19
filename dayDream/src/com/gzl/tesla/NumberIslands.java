package com.gzl.tesla;

import org.junit.Test;

public class NumberIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if (row >= m || row < 0 || col >= n || col < 0) {
            return;
        }
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    @Test
    public void test() {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = {{'0','1'},{'1','0'}};
        System.out.println("numIslands(grid) = " + numIslands(grid));
        System.out.println("numIslands(grid2) = " + numIslands(grid2));
    }
}
