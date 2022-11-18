/**
 * 162. 寻找峰值
 */
public class Code_10_02_find_peak_element {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int m = (r - l) / 2 + l;
            if(nums[m] < nums[m+1]){
                l = m + 1;
            }else{
                r = m;
            }
        }
        return l;
    }
}
