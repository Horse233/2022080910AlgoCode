//40.旋转图像
public class Code_8_12_rotate_image {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length-1;
        int m = matrix[0].length;
        for(int i = 0; i <= n / 2; i++){
            for(int j = 0; j <= (m / 2) -1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = tmp;
            }
        }
    }
    public void rotate2(int[][] matrix) {
        int n = matrix[0].length;
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < (n + 1) / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}
