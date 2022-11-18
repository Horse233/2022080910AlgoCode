public class Code_8_22_unique_paths {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i ++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j ++){
            dp[0][j] = 1;
        }
        for(int j = 1; j < n; j++){
            for(int i = 1; i < m; i ++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
    //数学排组合方法。
    /*
    从左上角移动到右下角，总共需要移动m+n-2步，其中有（m-1）步向下移动，
    （n-1）步向右移动。即有多少种向下移动的组合就是总的移动方法。
     */
    public int uniquePaths2(int m, int n){
        long ans = 1;
        for(int j = 0; j <= m - 2; j++){
            ans = ans * (n + j) / (1 + j);
        }
        return (int)ans;
    }
}
