//75.颜色分类
public class Code_8_31_sort_colors {
    public void sortColors(int[] nums) {
        int l = -1, r = nums.length;
        int i = 0;
        while(i < r){
            if(nums[i] == 0){
                swap(nums, i, l + 1);
                l ++;
                i ++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, i, r - 1);
                r --;
            }
        }
    }
    public void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
