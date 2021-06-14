package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stunning.palm.tree.util.TreeNode;

public class BinaryTreeRightSideView {
	public BinaryTreeRightSideView() {}
	
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return res;
    }
    
    public void helper(TreeNode root, int level){
        if(root == null) return;
        if(!map.containsKey(level)){
            res.add(root.val);
            map.put(level,root.val);
        }
        
        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}
