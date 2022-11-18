import java.util.ArrayList;
import java.util.List;

//77.组合
public class Code_9_1_combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<Integer>();
        backtrack(n, k, 1, ans, tmp);
        return ans;
    }
    public void backtrack(int n, int k, int cur, List<List<Integer>> ans, List<Integer> tmp){
        //剪枝
        if(n - cur + 1 < k - tmp.size()){
            return;
        }
        if(tmp.size() == k){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(; cur <= n; cur ++){
            tmp.add(cur);
            backtrack(n, k, cur + 1, ans, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    //另一种回溯写法
    public void backtrack2(int n, int k, int cur, List<List<Integer>> ans, List<Integer> tmp){
        if(n - cur + 1 < k - tmp.size()){
            return;
        }
        if(tmp.size() == k){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(cur);
        backtrack2(n, k, cur + 1, ans, tmp);
        tmp.remove(tmp.size() - 1);
        backtrack2(n, k, cur + 1, ans, tmp);
    }
}
