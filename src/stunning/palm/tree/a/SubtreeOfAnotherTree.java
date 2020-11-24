package stunning.palm.tree.a;

import stunning.palm.tree.util.TreeNode;

/*
 * compare each subtree using recursion and if is not move on to each left and right node of s
 */
public class SubtreeOfAnotherTree {
	public SubtreeOfAnotherTree() {}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null) return false;
		if(helper(s,t)) return true;
		return isSubtree(s.left,t) || isSubtree(s.right,t);
	}

	private boolean helper(TreeNode s, TreeNode t){
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		else if(s.val == t.val) return helper(s.left,t.left) && helper(s.right,t.right);
		else return false;
	}
}
