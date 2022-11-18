/**
 * 189. 轮转数组
 */
public class Code_10_13_rotate_array {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(n, k);
        for(int i = 0; i < count; i++){
            int pre = nums[i];
            int cur = i;
            do{
               int next = (cur + k) % n;
               int tmp = nums[next];
               nums[next] = pre;
               pre = tmp;
               cur = next;
            } while(cur != i);
        }
    }

    //求x与y的最大公约数
    public int gcd(int x, int y){
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        Code_10_13_rotate_array code1013 = new Code_10_13_rotate_array();
        code1013.rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
