import java.util.*;

/**
 * 187. 重复的DNA序列
 */
public class Code_10_12_repeated_dna_sequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            map.put(sub,map.getOrDefault(sub, 0)+1);
            if(map.get(sub) == 2){
                ans.add(sub);
            }
        }
        return ans;
    }
}
