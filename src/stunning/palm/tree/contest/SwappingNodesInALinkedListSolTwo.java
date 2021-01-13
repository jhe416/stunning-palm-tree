package stunning.palm.tree.contest;

import stunning.palm.tree.util.ListNode;

/*
 * find two nodes...change value..
 */
public class SwappingNodesInALinkedListSolTwo {
	public SwappingNodesInALinkedListSolTwo() {}
	
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode pointer = head;
        while(pointer != null){
            n++;
            pointer = pointer.next;
        }
        
        if(n==1) return head;

        ListNode start = head;
        for(int i=1;i<k;i++){
            start = start.next;
        }
        
        ListNode end = head;
        for(int i=1;i<n-k+1;i++){
            end = end.next;
        }
        
        int tmp = end.val;
        end.val = start.val;
        start.val = tmp;
        
        return head;
    }
}
