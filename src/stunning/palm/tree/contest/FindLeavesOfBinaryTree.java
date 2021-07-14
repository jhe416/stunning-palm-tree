package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stunning.palm.tree.util.TreeNode;

public class FindLeavesOfBinaryTree {
	public FindLeavesOfBinaryTree() {}
	
    Map<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return new ArrayList<>(map.values());
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        
        int l = helper(root.left);
        int r = helper(root.right);
        
        int level = Math.max(l,r)+1;
        map.computeIfAbsent(level, i->(new ArrayList<>())).add(root.val);
        return level;
    }
}
