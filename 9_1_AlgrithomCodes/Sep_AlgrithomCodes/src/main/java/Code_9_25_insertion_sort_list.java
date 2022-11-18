/**
 * 147. 对链表进行插入排序
 */
public class Code_9_25_insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = new ListNode(head.val);
        ListNode ansPre = dummyHead, ansCur = dummyHead.next, headCur = head.next;
        while(headCur != null){
            while(ansCur != null && headCur.val > ansCur.val){
                ansPre = ansCur;
                ansCur = ansCur.next;
            }
            ansPre.next = new ListNode(headCur.val);
            ansPre.next.next = ansCur;
            headCur = headCur.next;
            ansPre = dummyHead;
            ansCur = dummyHead.next;
        }
        return ansCur;
    }
}
