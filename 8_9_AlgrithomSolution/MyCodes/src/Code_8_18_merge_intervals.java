import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//56. 合并区间
public class Code_8_18_merge_intervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1) return intervals;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int aPre = intervals[0][0];
        int bPre = intervals[0][1];
        for(int i = 1; i < n; i++){
            int aCur = intervals[i][0];
            int bCur = intervals[i][1];
            if(bPre >= aCur){
                bPre = Math.max(bPre, bCur);
            }else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(aPre);
                tmp.add(bPre);
                ans.add(new ArrayList<>(tmp));
                aPre = aCur;
                bPre = bCur;
            }
            if(i==n-1){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(aPre);
                tmp.add(bPre);
                ans.add(new ArrayList<>(tmp));
            }
        }
        int[][] res = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;
    }
    //力扣官方题解
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    //根据官方题解我的实现
    public int[][] merge3(int[][] intervals){
        int n = intervals.length;
        if(n == 1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            int L = intervals[i][0], R = intervals[i][1];
            if(list.size() == 0 || list.get(list.size() - 1)[1] < L){
                list.add(new int[]{L, R});
            }else{
                list.get(list.size()-1)[1] = Math.max(R, list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
