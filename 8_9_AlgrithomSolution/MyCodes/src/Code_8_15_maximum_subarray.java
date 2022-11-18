//53.最大子数组和
/*
当连续的数组和小于0时，可以直接丢弃了，已经成为负担了。

 */
public class Code_8_15_maximum_subarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for(int num : nums){
            if(sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }
    public int maxSubArray2(int[] nums){
        int pre = 0;
        int res = nums[0];
        for(int num : nums){
            pre = Math.max(pre + num, num);
            res = Math.max(pre, res);
        }
        return res;
    }
}
