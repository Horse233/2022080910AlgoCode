class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Code_10_20_remove_linked_list_elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(head != null){
            if(head.val == val){
                head = head.next;
                pre.next = head;
            }else{
                head = head.next;
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}
