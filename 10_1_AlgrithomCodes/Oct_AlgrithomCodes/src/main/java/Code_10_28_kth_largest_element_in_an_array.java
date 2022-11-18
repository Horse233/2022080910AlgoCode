import org.junit.jupiter.api.Test;

public class Code_10_28_kth_largest_element_in_an_array {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k-1);
    }
    public int partition(int[] nums, int L, int R, int k){
        int l = L;
        int r = R;
        if(l >= r){
            return nums[l];
        }
        int pivot = nums[l];
        while(l < r){
            while(l < r && nums[r] <= pivot){
                r--;
            }
            if(l < r){
                nums[l] = nums[r];
            }
            while(l < r && nums[l] >= pivot){
                l++;
            }
            if(l < r){
                nums[r] = nums[l];
            }
        }
        nums[l] = pivot;
        if(l == k){
            return pivot;
        }else if(l > k){
            return partition(nums, L, l - 1, k);
        }else{
            return partition(nums, l+1, R, k);
        }
    }

    @Test
    public void findKthLargestTest(){
        System.out.println(findKthLargest(new int[]{1}, 1));
    }
}
