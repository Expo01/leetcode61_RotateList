public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;   // k can be > length. need full pass to find length since list doesn't cycle. need to truncate 'k
        ListNode countNode = head;
        while(countNode != null){
            count++;
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
        lagg = lag.next; // lagg now is the rotation node
        temp.next = null; // broke off pointer to rotation node
        temp = lagg;
        ListNode after = head; // takes from start of remaining rotation and inputs after dummy
        while(lagg!= null){
            dummy.next = lagg;
            temp = temp.next;
            lagg.next = after;
            after = lag;
            lagg = temp;
        }
        return dummy.next;
    }
}