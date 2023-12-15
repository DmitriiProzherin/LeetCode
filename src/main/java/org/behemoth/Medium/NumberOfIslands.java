package org.behemoth.Medium;

public class NumberOfIslands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int amount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    amount++;
                    eraseIsland(grid, i, j);
                }
            }
        }
        return amount;
    }

    private static void eraseIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }
        else {
            grid[i][j] = '0';
            eraseIsland(grid, i-1, j);
            eraseIsland(grid, i, j-1);
            eraseIsland(grid, i+1, j);
            eraseIsland(grid, i, j+1);
        }
    }
}
