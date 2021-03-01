package stunning.palm.tree.f;

import stunning.palm.tree.util.ListNode;

/*
 * same as the LowestCommonAncestorOfABinaryTreeIII
 * O(n)
 * space constant
 */
public class IntersectionOfTwoLinkedLists {
	public IntersectionOfTwoLinkedLists() {}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while(a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        
        return a;
    }
    
    
    public ListNode getIntersectionNodeSolTwo(ListNode headA, ListNode headB) {
        int length1 = getLength(headA);
        int length2 = getLength(headB);
        
        if(length1 > length2){
            for(int i=0;i<length1-length2;i++)
                headA = headA.next;
        }else if(length1 < length2){
            for(int i=0;i<length2-length1;i++)
                headB = headB.next;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
    
        return headA;
    }
    
    private int getLength(ListNode node){
        if(node == null) return 0;
        
        return 1 + getLength(node.next);
    }
}
