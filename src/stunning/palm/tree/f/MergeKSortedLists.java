package stunning.palm.tree.f;

import stunning.palm.tree.util.ListNode;

/*
 * divide and conquer time O(nklogk)
 * but saves space where O(k) k is the length of one list node.
 */
public class MergeKSortedLists {
	public MergeKSortedLists() {}
	
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return divideConquer(lists,0,lists.length-1);
    }
    
    private ListNode divideConquer(ListNode[] lists, int s, int e){
        if(s==e) return lists[s];
        int mid = s + (e-s)/2;
        
        ListNode left = divideConquer(lists,s,mid);
        ListNode right = divideConquer(lists,mid+1,e);
        
        return merge(left,right);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        
        while(left != null && right != null){
            if(left.val < right.val){
                pointer.next = new ListNode(left.val);
                left = left.next;
            }else{
                pointer.next = new ListNode(right.val);
                right = right.next;
            }
            pointer = pointer.next;
        }
        
        while(left != null){
            pointer.next = new ListNode(left.val);
            pointer = pointer.next;
            left = left.next;
        }
        
        while(right != null){
            pointer.next = new ListNode(right.val);
            pointer = pointer.next;
            right = right.next;
        }
        
        return head.next;
    }
    
    private ListNode merge1(ListNode left, ListNode right) {
		return right;
    	
    }
}
