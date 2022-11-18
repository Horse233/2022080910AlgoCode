//88.合并两个有序数组
public class Code_9_6_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m + n - 1;
        while(k >= 0){
            if(i == -1){
                nums1[k--] = nums2[j--];
            } else if(j == -1){
                return;
            }else if(nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
    }
}
