import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 207. 课程表
 */
public class Code_10_23_course_schedule {
   // 1. 广度优先搜索
    List<ArrayList<Integer>> edges; //用来存储每个节点指向的下一个节点，即每门课程是哪些课程的先修课程
    int[] indeg;    //用来存储每个节点的入度，即每门课程的先修课程的门数
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        indeg = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        while(!queue.isEmpty()){
            visited++;
            int u = queue.poll();
            for(Integer v : edges.get(u)){
                indeg[v]--;
                if(indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
