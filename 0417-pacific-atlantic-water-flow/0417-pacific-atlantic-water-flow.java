import java.util.*;

class Solution {

    private int rows;
    private int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacificVisited);
            dfs(heights, row, cols - 1, atlanticVisited);
        }

        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacificVisited);
            dfs(heights, rows - 1, col, atlanticVisited);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (pacificVisited[row][col] &&
                    atlanticVisited[row][col]) {

                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights,
                     int row,
                     int col,
                     boolean[][] visited) {

        visited[row][col] = true;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        for (int[] direction : directions) {

            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (nextRow < 0 || nextCol < 0 ||
                nextRow >= rows || nextCol >= cols ||
                visited[nextRow][nextCol] ||
                heights[nextRow][nextCol] < heights[row][col]) {

                continue;
            }

            dfs(heights, nextRow, nextCol, visited);
        }
    }
}