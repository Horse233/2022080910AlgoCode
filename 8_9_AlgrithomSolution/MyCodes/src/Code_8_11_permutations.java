import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//力扣 46.全排列 回溯
public class Code_8_11_permutations {
    boolean[] visit;
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        visit = new boolean[nums.length];
        backtrack(nums, ans, tmp, 0);
        return ans;
    }
    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> tmp, int depth){
        if(depth == nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            tmp.add(nums[i]);
            backtrack(nums, ans, tmp, depth + 1);
            visit[i] = false;
            tmp.remove(depth);
        }
    }
}
