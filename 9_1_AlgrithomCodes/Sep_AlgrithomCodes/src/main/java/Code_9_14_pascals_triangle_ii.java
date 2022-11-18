import java.util.ArrayList;
import java.util.List;

//119. 杨辉三角 II
public class Code_9_14_pascals_triangle_ii {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> pre;
        ans.add(1);
        for(int i = 1; i <= rowIndex; i++){
            pre = ans;
            ans = new ArrayList<>();
            for(int j = 0; j < pre.size()+1; j++){
                if(j == 0 || j == pre.size()){
                    ans.add(1);
                }else{
                    ans.add(pre.get(j-1) + pre.get(j));
                }
            }
        }
        return ans;
    }
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            List<Integer> ans = new ArrayList<>();
            for(int j = 0; j <= pre.size(); j++){
                if(j == 0 || j == pre.size()){
                    ans.add(1);
                }else{
                    ans.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = ans;
        }
        return pre;
    }
}
