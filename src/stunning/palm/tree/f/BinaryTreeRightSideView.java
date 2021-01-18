package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stunning.palm.tree.util.TreeNode;

/*
 * Time O(n)
 * Space o(n)
 */
public class BinaryTreeRightSideView {
	public BinaryTreeRightSideView() {}
	
    private List<Integer> res = new ArrayList<>();
    Map<Integer,TreeNode> map = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return res;
    }
    
    private void helper(TreeNode root,int level){
        if(root == null) return;
        if(map.get(level) == null){
            res.add(root.val);
        }
        map.put(level,root);
        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}
