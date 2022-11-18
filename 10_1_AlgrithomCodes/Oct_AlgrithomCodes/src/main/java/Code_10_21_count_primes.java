import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 204. 计数质数
 */
public class Code_10_21_count_primes {

    //方法超时
    public int countPrimes(int n) {
        int ans = 0;
        for(int i = 2; i < n; i++){
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }
    public boolean isPrime(int num){
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void countPrimesTest(){
        System.out.println(countPrimes(10));
    }

    public int countPrimes2(int n){
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i] == 1){
                ans ++;
                if((long) i * i < n){
                    for(int j = i * i; j < n; j += i){
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
    @Test
    public void countPrimes2Test(){
        System.out.println(countPrimes2(10));
    }
}
