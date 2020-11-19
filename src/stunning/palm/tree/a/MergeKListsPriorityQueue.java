package stunning.palm.tree.a;

import java.util.PriorityQueue;

import stunning.palm.tree.util.ListNode;

public class MergeKListsPriorityQueue {
	public MergeKListsPriorityQueue() {}
	
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
            while(node != null){
                q.offer(new ListNode(node.val));
                node = node.next;
            }
        }
        
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        while(!q.isEmpty()){
            pointer.next = q.poll();
            pointer = pointer.next;
        }
        
        return res.next;
    }
}
