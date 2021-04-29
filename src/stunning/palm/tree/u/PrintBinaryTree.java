package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.List;

import stunning.palm.tree.util.TreeNode;

/*
 * find h then fidn the max spaces for each list
 * then basically use divide and conquer fill each list on each level
 * Time O(n)
 * space O(n)
 */
public class PrintBinaryTree {
	public PrintBinaryTree() {}
	
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {
        int h = findHeight(root);
        int spaces = Double.valueOf(Math.pow(2,h)).intValue()-1;
        
        for(int i=0;i<h;i++){
            res.add(new ArrayList<>());
        }
        
        for(List<String> list : res){
            for(int i=0;i<spaces;i++)list.add("");
        }
        
        helper(root,res,0,spaces-1,0);
        return res;
    }
    
    private int findHeight(TreeNode root){
        if(root == null) return 0;
        
        return Math.max(findHeight(root.left),findHeight(root.right)) + 1;
    }
    
    private void helper(TreeNode root, List<List<String>> res, int s, int e, int level){
        if(root == null || s > e) return;
        List<String> list = res.get(level);
        int mid = s + (e-s)/2;
        list.set(mid,String.valueOf(root.val));
        helper(root.left,res,s,mid-1,level+1);
        helper(root.right,res,mid+1,e,level+1);
    }
}
