import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90.子集2
public class Code_9_8_subsets_ii {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, 0, ans, tmp, false);
        return ans;
    }
    public void backtrack(int[] nums, int k, List<List<Integer>> ans, List<Integer> tmp, boolean flag){
        if(k == nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[k]);
        if(!(k > 0 && nums[k] == nums[k - 1] && !flag)){
            backtrack(nums, k + 1, ans, tmp, true);
        }
        tmp.remove(tmp.size() - 1);
        backtrack(nums, k + 1, ans, tmp, false);
    }
}
