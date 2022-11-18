//63. 不同路径 II
public class Code_8_23_unique_paths_ii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = false;
        for(int i = m - 1; i >= 0; i--){
            if(!flag && obstacleGrid[i][n-1] == 1){
                dp[i][n-1] = 0;
                flag = true;
            }else if(!flag && obstacleGrid[i][0] == 0){
                dp[i][n-1] = 1;
            }else{
                dp[i][n-1] = 0;
            }
        }
        flag = false;
        for(int j = n - 1; j >= 0; j--){
            if(!flag && obstacleGrid[m-1][j] == 1){
                dp[m-1][j] = 0;
                flag = true;
            } else if (!flag && obstacleGrid[0][j] == 0)  {
                dp[m-1][j] = 1;
            }else {
                dp[m-1][j] = 0;
            }
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int ans[][]=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        if(obstacleGrid[0][0]==0){ans[1][1]=1;}
        for(int i=1;i<=obstacleGrid.length;i++){
            for(int j=1;j<=obstacleGrid[0].length;j++){
                if((i!=1||j!=1)&&obstacleGrid[i-1][j-1]==0){
                    ans[i][j]=ans[i-1][j]+ans[i][j-1];
                }
            }
        }
        return ans[obstacleGrid.length][obstacleGrid[0].length];
    }
    //滚动数组版
    public int uniquePathsWithObstacles22(int[][] obstacleGrid) {
        int ans[]=new int[obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid[0].length&&obstacleGrid[0][i]==0;i++){
            ans[i]=1;
        }
        for(int i=1;i<obstacleGrid.length;i++){
            int a[]=new int[obstacleGrid[0].length];
            if(obstacleGrid[i][0]==0){
                a[0]=ans[0];
            }
            for(int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==0){a[j]=a[j-1]+ans[j];
                }
            }
            ans=a;
        }
        return ans[obstacleGrid[0].length-1];
    }
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        if(obstacleGrid[0][0] == 0) dp[1][1] = 1;
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                if(!(i == 1 && j == 1) && obstacleGrid[i-1][j-1] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
