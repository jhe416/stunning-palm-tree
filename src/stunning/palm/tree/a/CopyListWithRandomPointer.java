package stunning.palm.tree.a;

import java.util.HashMap;
import java.util.Map;

import stunning.palm.tree.util.Node;

/*
 * recursion loop at the same time record each copied node as a map key for random pointer location
 * Time O(n)
 * Space O(n)
 */
public class CopyListWithRandomPointer {
	public CopyListWithRandomPointer() {}
	
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node,Node> map = new HashMap<>();
        return helper(map, head);
    }
    
    private Node helper(Map<Node,Node> map, Node head){
        if(head == null) return null;
        Node newHead = new Node(head.val);
        
        map.put(head,newHead);
        newHead.next = helper(map,head.next);
        newHead.random = map.get(head.random);
        return newHead;
    }
}
