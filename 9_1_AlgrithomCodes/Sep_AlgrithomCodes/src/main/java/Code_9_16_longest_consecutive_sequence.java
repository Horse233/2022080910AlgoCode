import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 */
public class Code_9_16_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            num_set.add(nums[i]);
        }
        int longestSequence = 0;
        for(int num : num_set){
            if(!num_set.contains(num+1)){
                int curSequence = 1;
                int curNum = num;
                while(num_set.contains(curNum - 1)){
                    curSequence += 1;
                    curNum -= 1;
                }
                longestSequence = Math.max(longestSequence, curSequence);
            }
        }
        return longestSequence;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
