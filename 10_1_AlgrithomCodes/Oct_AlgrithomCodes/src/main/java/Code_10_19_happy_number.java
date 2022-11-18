import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 */
public class Code_10_19_happy_number {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = nextNum(n);
        }
        return true;
    }
    public int nextNum(int n){
        int ans = 0;
        while(n != 0){
            int res = n % 10;
            ans += res * res;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Code_10_19_happy_number code1019 = new Code_10_19_happy_number();
        System.out.println(code1019.isHappy(2));
    }
}
