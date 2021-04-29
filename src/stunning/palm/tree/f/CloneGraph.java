package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import stunning.palm.tree.util.Node;

/*
 * with return, without return 
 * Time O(n)
 */
public class CloneGraph {
	public CloneGraph() {}
	
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        helper(node);
        return map.get(node);
    }
    
    private void helper(Node node){
        if(node == null) return;
        if(map.get(node) != null) return;
        
        Node newNode = new Node(node.val,new ArrayList<>());
        map.put(node,newNode);
        
        for(Node val : node.neighbors){
            helper(val);
            newNode.neighbors.add(map.get(val));
        }
    }
    
    /*
     * without return.
     * Time O(n)
     */
    public Node cloneGraphSolTwo(Node node) {
        if(node == null) return null;
        
        return helperTwo(node);
    }
    
    private Node helperTwo(Node node){
        if(node == null) return null;
        if(map.get(node) != null) return map.get(node);
        
        Node newNode = new Node(node.val,new ArrayList<>());
        map.put(node,newNode);
        
        for(Node val : node.neighbors){
            newNode.neighbors.add(helperTwo(val));
        }

        return newNode;
    }
}
