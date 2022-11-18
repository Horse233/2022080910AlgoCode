public class Code_10_14_reverse_bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
}
