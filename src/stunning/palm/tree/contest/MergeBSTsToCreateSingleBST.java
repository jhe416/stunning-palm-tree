package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import stunning.palm.tree.util.TreeNode;

public class MergeBSTsToCreateSingleBST {
	public MergeBSTsToCreateSingleBST() {}
	
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Map<TreeNode,TreeNode> pMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(TreeNode root : trees){
            map.put(root.val,root);
        }
        
        for(TreeNode root : trees){
            visited.add(root.val);
            if(root.right != null){
                visited.add(root.right.val);
                if(map.containsKey(root.right.val)){
                    TreeNode parent = pMap.getOrDefault(root,null);
                    //check if the node trying to connect is not the current root's parent
                    //this check works becuase all bst in this question has at most 3 nodes.
                    if(parent != map.get(root.right.val)){
                        root.right = map.get(root.right.val);
                        map.remove(root.right.val);
                        pMap.put(root.right,root);
                    }
                }
            }
            
            if(root.left != null){ 
                visited.add(root.left.val);
                if(map.containsKey(root.left.val)){
                    TreeNode parent = pMap.getOrDefault(root,null);
                    if(parent != map.get(root.left.val)){
                        root.left = map.get(root.left.val);
                        map.remove(root.left.val);
                        pMap.put(root.left,root);
                    }
                }
            }
        }
        
        if(map.size() != 1) return null;
        TreeNode res = new ArrayList<>(map.values()).get(0);
        return isValidBST(res)? getSize(res) == visited.size()? res : null : null;
    }
    
    public boolean isValidBST(TreeNode res){
        return helper(res, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean helper(TreeNode root, long max, long min){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        
        return helper(root.left,root.val,min) && helper(root.right,max,root.val);
    }
    
    private int getSize(TreeNode root){
        if(root == null) return 0;
        return getSize(root.left) + getSize(root.right) + 1;
    }
}
