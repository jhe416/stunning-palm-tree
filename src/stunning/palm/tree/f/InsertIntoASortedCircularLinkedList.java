package stunning.palm.tree.f;

import stunning.palm.tree.util.Node;

/*
 * 1, insert in between, easy
 * 2, insert after max, new max medium
 * 3, insert before min, new min, hard. need to loop again until the first min is found
 * Time O(n)
 * Space constant;
 * 
 */
public class InsertIntoASortedCircularLinkedList {
	public InsertIntoASortedCircularLinkedList() {}
	
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null){
            node.next = node;
            return node;
        }
        
        Node pointer = null;
        Node min = head;
        Node max = head;
        while(pointer != head){
            if(pointer == null) pointer = head;
            
            if(pointer.val <= insertVal && pointer.next.val > insertVal){
                node.next = pointer.next;
                pointer.next = node;
                return head;
            }
            if(pointer.next.val < min.val){
                min = pointer.next;
            }
            if(pointer.val >= max.val){
                max = pointer;
            }
            pointer = pointer.next;
        }
        
        if(insertVal > max.val || max.val == min.val){
            node.next = max.next;
            max.next = node;
            return head;
        }
        
        pointer = head;
        while(true){
            if(pointer.next.val == min.val && pointer.val > min.val){
                node.next = pointer.next;
                pointer.next = node;
                return head;
            }
            pointer = pointer.next;
        }
    }
}
