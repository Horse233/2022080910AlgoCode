import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * 166. 分数到小数
 */
public class Code_10_04_fraction_to_recurring_decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        double d = (numerator + 0.0) / denominator;
        String[] dStrList = String.valueOf(d).split("\\.");
        if(Objects.equals(dStrList[1], "0")) return dStrList[0];
        StringBuilder ans = new StringBuilder();
        ans.append(dStrList[0]).append(".");
        String repeat = dStrList[1];
        ans.append(helper(repeat));
        if(ans.toString().split("\\.").length == 1){
            ans.append(repeat);
        }
        return ans.toString();
    }
    public String helper(String repeat){
        StringBuilder sb = null;
        outer:
        for(int i = 0; i < repeat.length(); i++){
            sb = new StringBuilder();
            sb.append(repeat, 0, i);
//            System.out.println("sb = " + sb);
            HashSet<String> set = new HashSet<>();
            for(int j = i; j < repeat.length() / 2; j++){
                set.add(repeat.substring(i, j+1));
//                System.out.println("repeat.substring(i, j+1) = " + repeat.substring(i, j + 1));
//                System.out.println("repeat.substring(j+1,j+j+1) = " + repeat.substring(j + 1, j+j+2 -i));
                if(set.contains(repeat.substring(j+1, j+j+2 -i))){
                    sb.append("("+repeat.substring(i, j+1)+")");
                    break outer;
                }
            }
        }
        if(!sb.toString().contains("(")){
            return repeat;
        }else{
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        String s =
                new Code_10_04_fraction_to_recurring_decimal().
                        fractionToDecimal(1, 333);
        System.out.println(s);
    }
}
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuffer sb = new StringBuffer();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append('-');
        }

        // 整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');

        // 小数部分
        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainderIndexMap = new HashMap<Long, Integer>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }
        if (remainder != 0) { // 有循环节
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');
        }
        sb.append(fractionPart.toString());

        return sb.toString();
    }
}

