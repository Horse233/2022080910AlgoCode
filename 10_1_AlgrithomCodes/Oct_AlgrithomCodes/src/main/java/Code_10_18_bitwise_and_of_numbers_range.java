/**
 * 201. 数字范围按位与
 */
public class Code_10_18_bitwise_and_of_numbers_range {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while(left < right){
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }

    public int rangeBitwiseAnd2(int left, int right) {
        while(left < right){
            right = right & (right - 1);
        }
        return right;
    }
    public static void main(String[] args) {
        Code_10_18_bitwise_and_of_numbers_range code1018 = new Code_10_18_bitwise_and_of_numbers_range();
        System.out.println(code1018.rangeBitwiseAnd2(5, 7));
    }
}
