import java.util.*;

//47、全排列2
public class Code_8_10_permutations_2 {
    boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        visit = new boolean[nums.length];
        backtrack(nums, ans, temp, 0);
        return ans;
    }
    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index){
        if(index == nums.length){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visit[i] || (i > 0 && nums[i] == nums[i-1] && !visit[i-1])){
                continue;
            }
            temp.add(nums[i]);
            visit[i] = true;
            backtrack(nums, ans, temp, index + 1);
            visit[i] = false;
            temp.remove(index);
        }
    }
}
