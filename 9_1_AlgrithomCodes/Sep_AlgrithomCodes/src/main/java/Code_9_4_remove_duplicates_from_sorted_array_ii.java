//80.删除有序数组中的重复项II
/*
双指针，
slow指针指向已经规整的有序数列的下一位，
fast指向当前考察的有序数列的一位，
如果fast与slow的前2位相同，则表示重复
 */
public class Code_9_4_remove_duplicates_from_sorted_array_ii {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int slow = 2, fast = 2;
        while(fast < n){
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast ++;
        }
        return slow;
    }
}
