//69.x的平方根
public class Code_8_27_sqrtx {
    public int mySqrt(int x) {
        long i = 0;
        for(; i * i <= x; i++){
        }
        return (int) (i-1);
    }
    //二分查找
    public int mySqrt2(int x){
        int ans = -1;
        int l = 0, r = x;
        while(l <= r){
            int m = l + (r - l) / 2;
            if((long) m * m <= x){
                ans = m;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return ans;
    }
    //牛顿迭代法，找函数的0点
    public int mySqrt3(int x){
        if(x == 0) return 0;
        double C = x, x0 = C;
        while(true){
            double xi = (x0 + C / x0) / 2;
            if(Math.abs(xi-x0) < 1e-7){
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

}
