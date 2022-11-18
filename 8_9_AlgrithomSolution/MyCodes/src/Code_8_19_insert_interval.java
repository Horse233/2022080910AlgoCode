import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//57. 插入区间
public class Code_8_19_insert_interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n == 0) return new int[][]{newInterval};
        List<int[]> res = new ArrayList<>();
        int lMin =Integer.MAX_VALUE, rMax =Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int lCur = intervals[i][0], rCur = intervals[i][1];
            if(rCur < newInterval[0] || lCur > newInterval[1]){
                res.add(new int[]{lCur, rCur});
            }else{
                lMin = Math.min(lMin, Math.min(lCur, newInterval[0]));
                rMax = Math.max(rMax, Math.max(rCur, newInterval[1]));
                if(rMax != Integer.MAX_VALUE && (i+1 == n || rMax < intervals[i+1][0])){
                    res.add(new int[]{lMin, rMax});
                }
            }
            if((i== 0 && intervals[i][0] > newInterval[1]) || (i == n-1 && intervals[i][1] < newInterval[0])){
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int[][] newInter= new int[intervals.length + 1][2];
        for(int i = 0; i < intervals.length; i++){
            newInter[i][0] = intervals[i][0];
            newInter[i][1] = intervals[i][1];
        }
        newInter[intervals.length][0] = newInterval[0];
        newInter[intervals.length][1] = newInterval[1];
        return merge3(newInter);
    }
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
