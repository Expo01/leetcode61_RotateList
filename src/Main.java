


// editorial solution of forming and breaking a ring
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // edge cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}



// my solution, 0 ms runtime, beats 70% memory, just a little wordy compared to editorial solution
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){ return head;}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;   // k can be > length. need full pass to find length since list doesn't cycle. need to truncate 'k
        while(head != null){
            count++;
            head = head.next;
        }
        head = dummy.next;
        if(k % count == 0){
            return head;
        }
        if(k > count){
            k %= count;
        }
        ListNode lead = head; // lead and lagg for single pass aqcuiring of rotation node
        ListNode lagg = head;
        for(int i = 1; i<= k+1; i++){
            lead = lead.next;
        }
        while(lead != null){  // lagg is now 1 prior to roation node
            lead = lead.next;
            lagg = lagg.next;
        }
        ListNode temp = lagg;
        lagg = lagg.next; // lagg now is the rotation node
        temp.next = null; // broke off pointer to rotation node
        temp = lagg;
        ListNode after = head; // takes from start of remaining rotation and inputs after dummy
        ListNode before = dummy;
        while(lagg!= null){
            before.next = lagg;
            temp = temp.next;
            lagg.next = after;
            before = before.next;
            lagg = temp;
        }
        return dummy.next;
    }
}
// i'm adding 4 first. after doesnn't change, before should change so items added on R not L