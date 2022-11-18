import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//66. 加一
public class Code_8_25_plus_one {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int pre = 1;
        for(int i = digits.length - 1; i >= 0; i++){
            int cur = digits[i] + pre;
            pre = cur / 10;
            cur = cur % 10;
            list.add(0, cur);
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i ++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public int[] plusOne2(int[] digits){
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] = digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
