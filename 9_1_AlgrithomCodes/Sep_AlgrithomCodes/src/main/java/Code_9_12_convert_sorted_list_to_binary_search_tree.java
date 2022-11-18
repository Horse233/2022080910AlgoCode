
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


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
//109.有序链表转换为二叉搜索树
public class Code_9_12_convert_sorted_list_to_binary_search_tree {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTreeNode(head, null);
    }
    public TreeNode buildTreeNode(ListNode left, ListNode right){
        if(left == right) return null;
        ListNode mid = getMidNode(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTreeNode(left, mid);
        root.right = buildTreeNode(mid.next, right);
        return root;
    }
    public ListNode getMidNode(ListNode left, ListNode right){
        ListNode slow = left;
        ListNode fast = left;
        while(fast != right && fast.next != right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
