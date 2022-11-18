/**
 * 167. 两数之和 II - 输入有序数组
 */
public class Code_10_05_two_sum_ii_input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(numbers[l] + numbers[r] != target){
            if(numbers[l] + numbers[r] < target){
                l++;
            }else{
                r--;
            }
        }
        int[] ans = new int[2];
        ans[0] = l+1;
        ans[1] = r+1;
        return ans;
    }
    public int[] twoSum1(int[] numbers, int target){
        int l = 0;
        int r = numbers.length - 1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l+1, r+1};
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            }else{
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}
