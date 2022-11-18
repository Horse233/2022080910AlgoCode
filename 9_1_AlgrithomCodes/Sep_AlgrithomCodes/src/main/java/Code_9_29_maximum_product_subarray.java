/**
 * 152. 乘积最大子数组
 */
public class Code_9_29_maximum_product_subarray {
    public int maxProduct(int[] nums) {
        //记录历史最大
        int max = Integer.MIN_VALUE;
        //包含当前值的连续最大
        int imax = 1;
        //包含当前值的连续最小
        int imin = 1;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(imax, imin);
        }
        return max;
    }
}
