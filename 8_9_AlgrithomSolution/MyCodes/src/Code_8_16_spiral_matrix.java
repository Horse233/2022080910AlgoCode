import java.util.ArrayList;
import java.util.List;

//54. 螺旋矩阵
public class Code_8_16_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        int iMin = 0, iMax = m-1, jMin = 0, jMax = n-1;
        int d = 0;
        for(int k = 0; k < m*n; k ++){
            ans.add(matrix[i][j]);
            i += direction[d][0];
            j += direction[d][1];
            if(!(iMin <= i && i <= iMax && jMin <= j && j <= jMax)){
                if(d == 0){
                    i++;
                    j--;
                    iMin++;
                }else if(d == 1){
                    i--;
                    j--;
                    jMax--;
                }else if(d == 2){
                    j++;
                    i--;
                    iMax--;
                }else{
                    i++;
                    j++;
                    jMin++;
                }
                d++;
                d %= 4;
            }
        }
        return ans;
    }
    //官方答案
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
    //根据官方答案我的复现
    public List<Integer> spiralOrder3(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int iMin = 0, iMax = m-1, jMin = 0, jMax = n-1;
        List<Integer> ans = new ArrayList<>();
        while(iMin <= iMax && jMin <= jMax){
            for(int j = jMin; j <= jMax; j++){
                ans.add(matrix[iMin][j]);
            }
            for(int i = iMin+1; i <= iMax; i++){
                ans.add(matrix[i][jMax]);
            }
            if(jMin < jMax && iMin < iMax){
                for(int j = jMax-1; j >= jMin; j--){
                    ans.add(matrix[iMax][j]);
                }
                for(int i = iMax - 1; i >= iMin+1; i--){
                    ans.add(matrix[i][jMin]);
                }
            }
            iMin ++;
            iMax --;
            jMin ++;
            jMax --;
        }
        return ans;
    }
}



