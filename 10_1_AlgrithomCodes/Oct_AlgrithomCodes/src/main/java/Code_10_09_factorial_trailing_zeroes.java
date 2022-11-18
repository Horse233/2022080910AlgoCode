/**
 * 172. 阶乘后的零
 */
public class Code_10_09_factorial_trailing_zeroes {
    public int trailingZeroes(int n) {
        int k = 5;
        int ans = 0;
        if(n < 5){
            return ans;
        }
        while(k <= n){
            ans += (n / k);
            k *= 5;
        }
        return ans;
    }
    public int trailingZeroes1(int n) {
        int ans = 0;
        while(n >= 5){
            n /= 5;
            ans += n;
        }
        return ans;
    }

    public static void main(String[] args) {
        Code_10_09_factorial_trailing_zeroes code1009 = new Code_10_09_factorial_trailing_zeroes();
        System.out.println(code1009.trailingZeroes(125));
    }
}
