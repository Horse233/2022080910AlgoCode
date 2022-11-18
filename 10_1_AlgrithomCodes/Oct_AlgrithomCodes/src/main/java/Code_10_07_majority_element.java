import java.util.Arrays;

/**
 * 169. 多数元素
 */
public class Code_10_07_majority_element {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public int majorityElement2(int[] nums){
        int sum = 0;
        Integer vote = null;
        for(int num : nums){
            if(sum == 0){
                vote = num;
            }
            sum += num == vote ? vote : -vote;
        }
        return vote;
    }
}
