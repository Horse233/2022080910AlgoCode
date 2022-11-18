//81. 搜索旋转排序数组 II
public class Code_9_5_search_in_rotated_sorted_array_ii {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1) return nums[0] == target;
        int l = 0, r = n - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] == target) return true;
            if(nums[l] == nums[m] && nums[m] == nums[r]){
                l++;
                r--;
            }else if(nums[l] <= nums[m]){
                if(nums[m] > target && target >= nums[l]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else{
                if(nums[m] < target && target <= nums[r]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
        }
        return false;
    }
}

