/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class Code_9_30_find_minimum_in_rotated_sorted_array {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        if(nums[l] < nums[r]){
            return nums[l];
        }
        while(l < r){
            int m = (r - l) / 2 + l;
            if(nums[m] > nums[l]){
                l = m;
            }else if(nums[m] == nums[l]){
                return Math.min(nums[l], nums[r]);
            }else{
                r = m;
            }
        }
        return nums[l];
    }
}
