import java.util.HashMap;
import java.util.HashSet;

/**
 * 142. 环形链表II
 */

public class Code_9_24_linked_list_cycle_ii {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(true){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode detectCycle1(ListNode head) {
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        int i = 0;
        while(head != null){
            if(hashMap.containsKey(head)){
                return head;
            }
            hashMap.put(head, i++);
            head = head.next;
        }
        return null;
    }
}
