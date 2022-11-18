import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139.单次拆分
 */
public class Code_9_23_word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                dp[i] = dp[j] && wordDictSet.contains(s.substring(j, i));
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
