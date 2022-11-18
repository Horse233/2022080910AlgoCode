/**
 * 209. 长度最小的子数组
 */
public class Code_10_25_minimum_size_subarray_sum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(end < n){
            sum += nums[end];
            while(sum >= target){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
