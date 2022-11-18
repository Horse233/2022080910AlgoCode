//59. 螺旋矩阵 II
public class Code_8_21_spiral_matrix_ii {
    public static void main(String[] args) {
        Code_8_21_spiral_matrix_ii code_8_21_spiral_matrix_ii = new Code_8_21_spiral_matrix_ii();
        code_8_21_spiral_matrix_ii.generateMatrix4(4);
    }
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] direction = new int[][]{{0,1},{1,0},{0, -1}, {-1, 0}};
        int i = 0, j = 0;
        int d = 0;
        int iMin = 0, iMax = n-1, jMin = 0, jMax = n-1;
        for(int k = 1; k <= n *n; k++){
            ans[i][j] = k;
            i += direction[d % 4][0];
            j += direction[d % 4][1];
            if(j > jMax){
                iMin ++;
                j --;
                i ++;
                d ++;
            }
            if(i > iMax){
                jMax --;
                i --;
                j --;
                d ++;
            }
            if(j < jMin){
                iMax --;
                j ++;
                i --;
                d ++;
            }
            if(i < iMin){
                jMin ++;
                i ++;
                j ++;
                d ++;
            }
        }
        return ans;
    }
    //根据官方的思路调整自己的代码
    public int[][] generateMatrix3(int n) {
        int[][] ans = new int[n][n];
        int[][] direction = new int[][]{{0,1},{1,0},{0, -1}, {-1, 0}};
        int i = 0, j = 0;
        int d = 0;
        for(int k = 1; k <= n *n; k++){
            ans[i][j] = k;
            int nextI = i + direction[d][0];
            int nextJ = j + direction[d][1];
            if(nextI < 0 ||nextI >= n || nextJ < 0 || nextJ >= n || ans[nextI][nextJ] != 0){
                d = (d+1) % 4;
            }
            i += direction[d % 4][0];
            j += direction[d % 4][1];
        }
        return ans;
    }
    //根据官方答案自己的复现
    public int[][] generateMatrix2(int n){
        int[][] ans = new int[n][n];
        int curValue = 1;
        int maxValue = n * n;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int i = 0, j = 0;
        while(curValue <= maxValue){
            ans[i][j] = curValue;
            int nextI = i + directions[d][0];
            int nextJ = j + directions[d][1];
            curValue ++;
            if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || ans[nextI][nextJ] != 0){
                d = (d + 1) % 4;
            }
            i += directions[d][0];
            j += directions[d][1];
        }
        return ans;
    }
    public int[][] generateMatrix4(int n) {
        int[][] ans = new int[n][n];
        int k = 1;
        int iMin = 0, iMax = n - 1, jMin = 0, jMax = n - 1;
        while(k <= n * n){
            for(int i = iMin, j = jMin; j <= jMax; j ++)ans[i][j] = k ++;
            iMin ++;
            for(int j = jMax, i = iMin; i <= iMax; i++)ans[i][j] = k ++;
            jMax --;
            for(int i = iMax, j = jMax; j >= jMin; j--)ans[i][j] = k ++;
            iMax--;
            for(int j = jMin, i = iMax; i >= iMin; i--)ans[i][j] = k ++;
            jMin++;
        }
        return ans;
    }
}
