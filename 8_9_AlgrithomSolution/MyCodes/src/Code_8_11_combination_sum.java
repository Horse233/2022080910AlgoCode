import java.util.*;

public class Code_8_11_combination_sum {
    //我的解法
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        backtrack(candidates, ans, tmp, target, 0);
        return ans;
    }
    public void backtrack(int[] nums, List<List<Integer>> ans, LinkedList<Integer> tmp, int target, int begin){
        if(target == 0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = begin; i < nums.length; i ++){
            if(target <=0){
                return;
            }else{
                target -= nums[i];
                tmp.add(nums[i]);
                backtrack(nums, ans, tmp, target, i);
                target += nums[i];
                tmp.remove(tmp.size()-1);
            }
        }
    }


    //力扣解法
    public List<List<Integer>> combinationSumLeetCode(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    //根据力扣的思路，自己的实现
    public List<List<Integer>> combinationSumLeetCode2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        dfs2(candidates, ans, tmp, target, 0);
        return ans;
    }
    public void dfs2(int[] nums, List<List<Integer>> ans, List<Integer> tmp, int target, int idx){
        if(idx == nums.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }
        dfs2(nums, ans, tmp, target, idx + 1);
        if(target - nums[idx] >= 0){
            target -= nums[idx];
            tmp.add(nums[idx]);
            dfs2(nums, ans, tmp, target, idx);
            tmp.remove(tmp.size() - 1);
        }
    }

}
