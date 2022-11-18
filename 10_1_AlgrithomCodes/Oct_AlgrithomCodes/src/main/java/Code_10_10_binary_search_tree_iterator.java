import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

//还可以采用双端队列实现


public class Code_10_10_binary_search_tree_iterator {
    Deque<Integer> list;
    public Code_10_10_binary_search_tree_iterator(TreeNode root) {
        list = new ArrayDeque<>();
        dfs(root, list);
    }

    public int next() {
        return list.removeFirst();
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }

    public void dfs(TreeNode root, Deque<Integer> list){
        if(root != null){
            dfs(root.left, list);
            list.addLast(root.val);
            dfs(root.right, list);
        }
    }
}
