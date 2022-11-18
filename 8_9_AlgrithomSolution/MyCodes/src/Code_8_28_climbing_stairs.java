//70.爬楼梯
public class Code_8_28_climbing_stairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n == 1 || n == 2){
            return n;
        }
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs2(int n){
        if(n == 1 || n == 2) return n;
        int dp1 = 1;
        int dp2 = 2;
        int dp3 = 0;
        for(int i = 3; i <= n; i ++){
            dp3 = dp2 + dp1;
            dp1 = dp2;
            dp2 = dp3;
        }
        return dp3;
    }
}
