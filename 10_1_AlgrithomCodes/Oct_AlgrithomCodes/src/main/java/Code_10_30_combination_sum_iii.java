import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 */
public class Code_10_30_combination_sum_iii {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack2(ans, tmp, k, n, 1, 0);
        return  ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> tmp, int k, int n, int  i, int sum){
        if(k == 0 && sum == n){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(sum > n || i > 9){
            return;
        }
        tmp.add(i);
        sum += i;
        k--;
        i++;
        backtrack(ans, tmp, k, n, i, sum);
        tmp.remove(tmp.size() - 1);
        k++;
        sum = sum - (i-1);
        backtrack(ans, tmp, k, n, i, sum);
    }
    public void backtrack2(List<List<Integer>> ans, List<Integer> tmp, int k, int n, int i, int sum){
        if(k == 0 && sum == n){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(sum > n || k < 0){
            return;
        }
        for(int j = i; j <= 9; j++){
            //选择j
            tmp.add(j);
            sum = sum + j;
            k = k - 1;
            j = j + 1;
            backtrack2(ans, tmp, k, n, j, sum);
            //不选j
            sum = sum - j + 1;
            k = k + 1;
            tmp.remove(tmp.size() - 1);
            backtrack2(ans, tmp, k, n, j + 1, sum);
        }
    }



    @Test
    public void combinationSum3Test(){
        combinationSum3(3, 9);
    }
}
