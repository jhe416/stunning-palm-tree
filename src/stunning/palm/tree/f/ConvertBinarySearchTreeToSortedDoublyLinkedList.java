package stunning.palm.tree.f;

import stunning.palm.tree.util.Node;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	public ConvertBinarySearchTreeToSortedDoublyLinkedList() {}
	
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        inOrder(root);
        first.left = last;
        last.right = first;
        
        return first;
    }
    
    public void inOrder(Node root){
        if(root == null) return;
        
        inOrder(root.left);
        if(last == null){
            first = root;
        }else{
            last.right = root;
            root.left = last;
        }
        
        last = root;
        
        inOrder(root.right);
    }
}
