package stunning.palm.tree.f;

import stunning.palm.tree.util.Node;

/*
 * catching up the lowest level then move up at the same time until parent found
 * Time O(h)
 * space constant
 */
public class LowestCommonAncestorOfABinaryTreeIII {
    public Node lowestCommonAncestor(Node p, Node q) {
        int level1=0;
        Node node1 = p;
        while(p != null){
            p = p.parent;
            level1++;
        }
        
        int level2 = 0;
        Node node2 = q;
        while(q != null){
            level2++;
            q = q.parent;
        }
        
        if(level2 < level1){
            for(int i=0;i<level1-level2;i++){
                node1 = node1.parent;
            }
        }else if(level2 > level1){
            for(int i=0; i<level2 - level1;i++){
                node2 = node2.parent;
            }
        }
        
         while(node1!=node2){
                node1 = node1.parent;
                node2 = node2.parent;
        }
        
        return node1;
    }
    
    /*
     * going circle and eventually they will meet
     * O(h)
     * Time O(1)
     */
    public Node lowestCommonAncestorSolTwo(Node p, Node q) {
        Node a = p, b = q;
        while(a!=b){
            a = a == null? q : a.parent;
            b = b == null? p : b.parent;
        }
        
        return a;
    }
}
