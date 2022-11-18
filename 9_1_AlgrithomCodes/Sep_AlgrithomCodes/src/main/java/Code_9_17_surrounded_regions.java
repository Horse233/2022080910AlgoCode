/**
 * 130.被围绕的区域
 * 将直接和间接与边界相连的O标记为A
 */
public class Code_9_17_surrounded_regions {
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for(int j = 1; j < n-1; j++){
            dfs(board, m-1, j);
            dfs(board, 0, j);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'A';
        dfs(board, i-1, j);
        dfs(board, i+1,j);
        dfs(board, i, j - 1);
        dfs(board, i, j+1);
    }
}
