import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 199. 二叉树的右视图
 */

public class Code_10_16_binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        ans.add(root.val);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = deque.removeFirst();
                if(i == size - 1){
                    ans.add(cur.val);
                }
                if(cur.left != null){
                    deque.addLast(cur.left);
                }
                if(cur.right != null){
                    deque.addLast(cur.right);
                }
            }
        }
        return ans;
    }
}
