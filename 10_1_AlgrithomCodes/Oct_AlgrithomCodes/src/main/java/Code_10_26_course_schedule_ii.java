import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 210. 课程表 II
 */
public class Code_10_26_course_schedule_ii {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> edges = new ArrayList<>();
        int[] indegs = new int[numCourses];
        int[] ans = new int[numCourses];
        int j = 0;
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
            indegs[info[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < indegs.length; i++){
            if(indegs[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            ans[j++] = u;
            for(Integer v : edges.get(u)){
                indegs[v]--;
                if(indegs[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return j==numCourses ? ans : new int[0];
    }
}
