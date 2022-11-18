//91.解码方法
public class Code_9_9_decode_ways {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        if('1' <= chars[0]  && chars[0] <= '9'){
            dp[1] = 1;
        }else{
            return 0;
        }
        for(int i = 1; i < chars.length; i ++){
            int charCur = chars[i] - '0';
            int charPre = chars[i-1] - '0';
            int combine = charPre * 10 + charCur;
            if(charCur == 0){
                if(combine == 10 || combine == 20){
                    dp[i+1] = dp[i-1];
                }else{
                    return 0;
                }
            }else{
                if(11 <= combine && combine <= 26){
                    dp[i+1] = dp[i] + dp[i-1];
                }else{
                    dp[i+1] = dp[i];
                }
            }
        }
        return dp[chars.length];
    }
    public int numDecodings2(String s){
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == 0){
            return 0;
        }else{
            dp[1] = 1;
        }
        for(int i = 1; i < s.length(); i++){
            int cur = s.charAt(i) - '0';
            int pre = s.charAt(i-1) - '0';
            int combine = pre * 10 + cur;
            if(cur == 0){
                if(pre == 1 || pre == 2){
                    dp[i+1] = dp[i-1];
                }else{
                    return 0;
                }
            }else{
                dp[i+1] = dp[i];
                if(11<= combine && combine <= 26){
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[s.length()];
    }
}
