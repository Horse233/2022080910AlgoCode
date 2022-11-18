//73.矩阵置零
public class Code_8_29_set_matrix_zeroes {
    //根据官方题解思路，用一个flag记录第一列是否有0，并根据这个flag来更新第一列
    //然后用第一行和第一列来记录需要更新为0的位置。
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0) flag = true;
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = 1; j < n; j ++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(flag){
                matrix[i][0] = 0;
            }
        }
    }
    //用flag来记录第一行是否有0，以此来更新
    public void setZeroes2(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        boolean flag = false;
        for(int j = 0; j < n; j ++){
            if(matrix[0][j] == 0) flag = true;
            for(int i = 1; i < m; i ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int j = n - 1; j >= 0; j--){
            for(int i = m -1; i >= 1; i--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(flag){
                matrix[0][j] = 0;
            }
        }
    }
}
