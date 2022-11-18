/**
 * 148. 排序链表
 */
public class Code_9_26_sort_list {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    public ListNode sortList(ListNode head, ListNode tail){
        if(head == null) return null;
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = sortList(head, slow), head2 = sortList(slow, tail);
        return merge(head1, head2);
    }
    public ListNode merge(ListNode node1, ListNode node2){
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead, head1 = node1, head2 = node2;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                tmp.next = head1;
                head1 = head1.next;
            }else{
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = head1 == null ? head2 : head1;
        return dummyHead.next;
    }
}
/*
if (head == null) {
    return head;
}
if (head.next == tail) {
    head.next = null;
    return head;
}
ListNode slow = head, fast = head;
while (fast != tail) {
    slow = slow.next;
    fast = fast.next;
    if (fast != tail) {
        fast = fast.next;
    }
}
ListNode mid = slow;
ListNode list1 = sortList(head, mid);
ListNode list2 = sortList(mid, tail);
ListNode sorted = merge(list1, list2);
return sorted;

 */
