/**
 * 136. 只出现一次的数字
 */
/*
 * java 位运算符号：
 *      1、& 与
 *      2、| 或
 *      3、~ 非
 *      4、^ 异或
 *      5、~ 位取反
 */
public class Code_9_21_single_number {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans = ans ^ num;
        }
        return ans;
    }
}
