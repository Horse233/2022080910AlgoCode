/**
 * 200. 岛屿数量
 */
public class Code_10_17_number_of_islands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    ans ++;
                    backtrack(visited, grid, i, j, m, n);
                }
            }
        }
        return ans;
    }
    public void backtrack(boolean[][] visited, char[][] grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        backtrack(visited, grid, i + 1, j, m, n);
        backtrack(visited, grid, i, j + 1, m, n);
        backtrack(visited, grid, i - 1, j, m, n);
        backtrack(visited, grid, i, j - 1, m, n);
    }

    public static void main(String[] args) {
        Code_10_17_number_of_islands code1017 = new Code_10_17_number_of_islands();
        code1017.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},{'0', '0', '1', '0', '0'},{'0', '0', '0', '1', '1'}});
    }
}
