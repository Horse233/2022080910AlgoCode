import org.junit.jupiter.api.Test;

import java.util.Random;


/**
 * 912. 排序数组
 */
public class Code_10_29_sort_an_array {
    public int[] sortArray(int[] nums) {
        quickSortRandomPivot(nums, 0, nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums, int L, int R){
        if(L >= R){
            return;
        }
        int l = L;
        int r = R;
        int Pivot = nums[l];
        while(l < r){
            while(l < r && nums[r] >= Pivot){
                r--;
            }
            if(l < r){
                nums[l] = nums[r];
            }
            while(l < r && nums[l] <= Pivot){
                l++;
            }
            if(l < r){
                nums[r] = nums[l];
            }
        }
        nums[l] = Pivot;
        quickSort(nums, L, l-1);
        quickSort(nums, l+1, R);
    }

    public void quickSortRandomPivot(int[] nums, int L, int R){
        int l = L;
        int r = R;
        if (l >= r){
            return;
        }
        int i = new Random().nextInt(R - L + 1) + L;
        swap(nums, l, i);
        int pivot = nums[l];
        while(l < r){
            while(l < r && nums[r] >= pivot){
                r--;
            }
            if(l < r){
                nums[l] = nums[r];
            }
            while(l < r && nums[l] <= pivot){
                l++;
            }
            if(l < r){
                nums[r] = nums[l];
            }
        }
        nums[l] = pivot;
        quickSortRandomPivot(nums, L, l - 1);
        quickSortRandomPivot(nums, l+1, R);
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    @Test
    public void sortArrayTest(){
        sortArray(new int[]{5,2,3,1});
    }
}
