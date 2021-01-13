package stunning.palm.tree.contest;

import stunning.palm.tree.util.ListNode;

/*
 * my solution, finding that two node and swamp.
 * consider lots special cases..
 * Time O(N)
 * space constant
 */
public class SwappingNodesInALinkedList {
	public SwappingNodesInALinkedList() {}
	
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode pointer = head;
        while(pointer != null){
            n++;
            pointer = pointer.next;
        }
        
        if(n==1) return head;
        
        ListNode preStart = null;
        ListNode start = head;
        for(int i=1;i<k;i++){
            preStart = start;
            start = start.next;
        }
        
        ListNode preEnd = null;
        ListNode end = head;
        for(int i=1;i<n-k+1;i++){
            preEnd = end;
            end = end.next;
        }
        
        if(preStart == null){
            ListNode save = end.next;
            if(start.next == end){
                end.next = start;
                start.next = save;
                return end;
            }
            
            end.next = start.next;
            preEnd.next = start;
            start.next = save;
            return end;
        }else if(preEnd == null){
            ListNode save = start.next;
            if(end.next == start){
                start.next = end;
                end.next = save;
                return start;
            }
            start.next = end.next;
            preStart.next = end;
            end.next = save;
            return start;
        }else{
            if(k>n-k+1){
                ListNode tmp = end;
                end = start;
                start = tmp;
                
                tmp = preEnd;
                preEnd = preStart;
                preStart = tmp;
            }
            
            ListNode save = end.next;
            if(start.next == end){
                end.next = start;
                start.next = save;
                preStart.next = end;
                return head;
            }
            
            end.next = start.next;
            preEnd.next = start;
            start.next = save;
            preStart.next = end;
            return head;
        }
    }
}
