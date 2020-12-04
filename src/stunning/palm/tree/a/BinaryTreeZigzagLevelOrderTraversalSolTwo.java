package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.List;

import stunning.palm.tree.util.TreeNode;

/*
 * another solution, instead of doing level order.
 * we know each level and which level the direction would be.
 * pre order the tree and add node to the correct level in the list with the correct direction depending
 * on the level.
 * Time O(n)
 * Space O(n)
 */
public class BinaryTreeZigzagLevelOrderTraversalSolTwo {
	public BinaryTreeZigzagLevelOrderTraversalSolTwo() {}
	
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        preOrder(root,0);
        return res;
    }
    
    private void preOrder(TreeNode root, int level){
        if(root == null) return;
        
        List<Integer> list = res.size() <= level? null : res.get(level);
        if(list == null){
            list = new ArrayList<>();
            res.add(list);
        }
        
        if(level%2 ==0){
            list.add(root.val);
        }else{
            list.add(0,root.val);
        }
        
        preOrder(root.left,level+1);
        preOrder(root.right,level+1);
    }
}
