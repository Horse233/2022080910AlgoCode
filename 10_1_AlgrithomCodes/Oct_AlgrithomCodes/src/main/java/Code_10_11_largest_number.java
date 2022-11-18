/**
 * 179. 最大数
 */
public class Code_10_11_largest_number {

    //这里采用了冒泡排序
    public String largestNumber(int[] nums) {
        for(int i = 0; i <nums.length; i++){
            int j = nums.length-1;
            while(j > i){
                if(bigger(nums[j], nums[j-1])){
                    swap(nums, j, j-1);
                }
                j--;
            }
        }
        if(nums[0] == 0) return "0";
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            ans.append(nums[i]);
        }
        return ans.toString();
    }

    //练习快排：采用快排再做一遍
    public String largestNumber2(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if(nums[0] == 0) return "0";
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            ans.append(nums[i]);
        }
        return ans.toString();
    }
    public void quickSort(int[] nums, int l , int r){
        if(l >= r) return;
        int i = l;
        int j = r;
        int pivot = nums[i];
        while(i < j){
            while(i < j && bigger(pivot, nums[j])){
                j--;
            }
            if(i < j){
                swap(nums, i, j);
            }
            while(i < j && notBigger(pivot, nums[i])){
                i++;
            }
            if(i < j){
                swap(nums, i, j);
            }
        }
        quickSort(nums, l, i-1);
        quickSort(nums, i+1, r);
    }

    public boolean bigger(int a, int b){
        long c = Long.parseLong(String.valueOf(a)+String.valueOf(b));
        long d = Long.parseLong(String.valueOf(b)+String.valueOf(a));
        return c > d;
    }
    public boolean notBigger(int a, int b){
        return !bigger(a, b);
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Code_10_11_largest_number code1011 = new Code_10_11_largest_number();
        System.out.println(code1011.largestNumber2(new int[]{3,30,34,5,9}));
    }
}


