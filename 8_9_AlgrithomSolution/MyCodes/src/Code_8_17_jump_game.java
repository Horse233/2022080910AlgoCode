//55. 跳跃游戏
public class Code_8_17_jump_game {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        int end = 0;
        for(int i =0; i <= end && i < n-1; i ++){
            end = Math.max(i + nums[i], end);
            if(end >= n-1) return true;
        }
        return false;
    }
}
