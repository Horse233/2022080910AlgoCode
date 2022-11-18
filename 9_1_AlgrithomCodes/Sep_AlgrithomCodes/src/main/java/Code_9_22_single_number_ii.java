/**
 * 137. 只出现一次的数字II
 */
public class Code_9_22_single_number_ii {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for(int num : nums){
            int aNext = (~a&b&num) | (a&~b&~num), bNext = ~a&(b^num);
            a = aNext;
            b = bNext;
        }
        return b;
    }
}
