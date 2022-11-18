//74.搜索二维矩阵
public class Code_8_30_search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
    //二分法，参考官方解法
    public boolean searchMatrix2(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while(l <= n){
            int mid = l + (r - l) / 2;
            int x = matrix[mid / m][mid % n];
            if(x > target){
                r = mid - 1;
            }else if(x < target){
                l = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
