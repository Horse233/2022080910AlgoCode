import java.util.ArrayList;
import java.util.List;

//118.杨辉三角
public class Code_9_13_pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        ans.add(new ArrayList<>(tmp));
        for(int i = 2; i <= numRows; i++){
            tmp = new ArrayList<>();
            List<Integer> pre = ans.get(i-2);
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i-1){
                    tmp.add(1);
                }else{
                    tmp.add(pre.get(j-1) + pre.get(j));
                }
            }
            ans.add(new ArrayList(tmp));
        }
        return ans;
    }
}
