import java.util.ArrayList;
import java.util.List;

//73.子集
public class Code_9_2_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, 0, ans, tmp);
        return ans;
    }
    public void backtrack(int[] nums, int cur, List<List<Integer>> ans, List<Integer> tmp){
        if(cur == nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[cur]);
        backtrack(nums, cur + 1, ans, tmp);
        tmp.remove(tmp.size() - 1);
        backtrack(nums, cur + 1, ans, tmp);
    }
}
