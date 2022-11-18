public class Code_10_15_number_of_1_bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                ans++;
            }
            n >>= 1;
        }
        return ans;
    }
}
