//45. 跳跃游戏 II
public class Code_8_9_JumpGame2 {
    //我的题解 反向查找出发位置
    public int jump(int[] nums){
        int l = nums.length;
        if(l <= 1) return 0;
        int p = l - 1;
        int step  = 0;
        int tmp = l-1;
        while(tmp != 0){
            for(int j = p; j >= 0; j --){
                if(nums[j] >= p-j) tmp = j;
            }
            p = tmp;
            step ++;
        }
        return step;
    }
    //官方题解，找最左边能够达到p的位置，然后更新p
    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
    //根据官方题解，自我实现
    public int jump3(int[] nums){
        int p = nums.length - 1;
        if(p <= 0) return 0;
        int steps = 0;
        while(p > 0){
            for(int i = 0; i <= p; i++){
                if(nums[i] + i >= p){
                    p = i;
                    steps ++;
                    break;
                }
            }
        }
        return steps;
    }
    //方法二：正向查找可到达的最大位置，官方解答
    public int jump4(int[] nums){
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
    //方法二：根据官方代码，我的实现
    /*
    在一个最大的范围内，找到下一个更大的范围。每一次都将这个更大的范围作为边界，来更新下一个最大的范围。
     */
    public int jump5(int[] nums){
        int l = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < l-1; i++){
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end){
                end = maxPosition;
                steps ++;
            }
        }
        return steps;
    }
}
