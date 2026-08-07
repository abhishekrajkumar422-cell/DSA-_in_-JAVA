class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int islands = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {

                    islands++;

                    dfs(grid, visited, i, j);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {

        // Boundary Check
        if (i < 0 || j < 0 ||
            i >= grid.length ||
            j >= grid[0].length) {
            return;
        }

        // Water ya Already Visited
        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        // Mark as Visited
        visited[i][j] = true;

        // 4 Directions
        dfs(grid, visited, i + 1, j); // Down
        dfs(grid, visited, i - 1, j); // Up
        dfs(grid, visited, i, j + 1); // Right
        dfs(grid, visited, i, j - 1); // Left
    }
}