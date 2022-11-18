//50.
public class Code_8_14_powx_n {
    public double myPow(double x, int n) {
        return quickPow2(x, n);
    }
    public double quickPow2(double x, long n){
        if(n < 0){
            return 1 / quickPow2(x, -n);
        }else if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }else{
            double y = quickPow2(x, n / 2);
            return n % 2 == 0 ? y * y : y * y * x;
        }
    }
    //快速幂，迭代
    public double myPow2(double x, int n){
        double res = 1.0;
        for(int i = n; i !=0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
    //快速幂，递归
    public double myPow3(double x, int n){
        return n > 0 ? quickPow(x, n) : quickPow(x, -n);
    }
    public double quickPow(double x, int n){
        if(n == 0){
            return 1.0;
        }
        double y = quickPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
