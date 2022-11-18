import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class Code_9_15_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                }else if(j == i){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                }else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < triangle.size(); i++){
            ans = Math.min(ans, dp[triangle.size()-1][i]);
        }
        return ans;
    }
}
