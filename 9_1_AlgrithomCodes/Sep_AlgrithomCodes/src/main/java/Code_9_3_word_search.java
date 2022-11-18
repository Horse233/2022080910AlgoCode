//79.单词搜索
public class Code_9_3_word_search {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(backtrack(board, word, i, j, 0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int i, int j, int k, boolean[][] visited){
        if(board[i][j] != word.charAt(k)){
            return false;
        }else if(k == word.length() - 1){
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int[] d : directions){
            int newI = i + d[0], newJ = j + d[1];
            if(0 <= newI && newI < board.length && 0 <= newJ && newJ < board[0].length && !visited[newI][newJ]){
                if(backtrack(board, word, newI, newJ, k+1, visited)){
                    result = true;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
    //官方题解思路
    public boolean exist2(char[][] board, String word){
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(backtrack2(board, word, i, j, 0, visited)) return true;
            }
        }
        return false;
    }
    public boolean backtrack2(char[][] board, String word, int i, int j, int k, boolean[][] visited){
        if(board[i][j] != word.charAt(k)){
            return false;
        }else if(k == word.length() - 1){
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int[] d : directions){
            int newI = i + d[0], newJ = j + d[1];
            if(0 <= newI && newI < board.length && 0 <= newJ && newJ < board[0].length &&
                    !visited[newI][newJ]){
                boolean flag = backtrack2(board, word, newI, newJ, k + 1, visited);
                if(flag){
                    result = true;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
