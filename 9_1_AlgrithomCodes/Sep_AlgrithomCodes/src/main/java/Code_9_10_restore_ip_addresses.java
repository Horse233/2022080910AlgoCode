import java.util.ArrayList;
import java.util.List;

//93. 复原 IP 地址
public class Code_9_10_restore_ip_addresses {
    static final int SEG_COUNT = 4;
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int[] segments = new int[SEG_COUNT];
        backtrack(s, 0, 0, ans, segments);
        return ans;
    }
    public void backtrack(String s, int segStart, int segId, List<String> ans, int[] segments){
        if(segId == SEG_COUNT){
            if(segStart == s.length()){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < SEG_COUNT; i++){
                    sb.append(segments[i]);
                    if(i != SEG_COUNT - 1){
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }
        if(segStart == s.length()) return;
        if(s.charAt(segStart) == '0'){
            segments[segId] = 0;
            backtrack(s, segStart + 1, segId + 1, ans, segments);
        }
        int addr = 0;
        for(int segEnd = segStart; segEnd < s.length(); segEnd ++){
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if(0 < addr && addr <= 0xFF){
                segments[segId] = addr;
                backtrack(s, segEnd + 1, segId + 1, ans, segments);
            }else{
                break;
            }
        }
    }
}
