package stunning.palm.tree.a;
import stunning.palm.tree.util.ListNode;
/*
 * merge sort solution with sort complexity always at O(nlogn)
 * but the space complexity reduced from O(n*k) to just O(k) as the merge sort solution
 * do not need to store everything into a sort data structure.
 */
public class MergeKSortedListsMergeSort {
	public MergeKSortedListsMergeSort() {}
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists,0,lists.length-1);
    }
    
    private ListNode merge(ListNode[] lists, int s, int e){
        if(s == e) return lists[s];

        int mid = s + (e-s)/2;
        ListNode left = merge(lists,s,mid);
        ListNode right = merge(lists,mid+1,e);
        return mergeTwoList(left,right);
    }
    
    private ListNode mergeTwoList(ListNode node1, ListNode node2){
        ListNode res = new ListNode(0);
        ListNode merge = res;
        while(node1 != null && node2 != null){
            if(node1.val > node2.val){
                merge.next = new ListNode(node2.val);
                node2 = node2.next;
            }else{
                merge.next = new ListNode(node1.val);
                node1 = node1.next;
            }
            
            merge = merge.next;
        }
        
        while(node1!=null){
            merge.next = new ListNode(node1.val);
            node1 = node1.next;
            merge = merge.next;
        }
        
        while(node2 != null){
            merge.next = new ListNode(node2.val);
            node2 = node2.next;
            merge = merge.next;
        }
        
        return res.next;
    }
}
