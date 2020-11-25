package stunning.palm.tree.util;

import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
    public Node next;
    public Node random;
    public List<Node> neighbors;

    public Node() {}
    
    public Node(int _val){this.val = _val;}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
    
    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
    
    public static Node getNode(int data)  
    {  
        // allocate memory for node  
        Node newNode = new Node();  
      
        // put in the data  
        newNode.val = data;  
        newNode.next = null;  
        return newNode;  
    }  
};
