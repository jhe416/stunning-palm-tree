package stunning.palm.tree.a;

import stunning.palm.tree.util.TreeNode;

/*
 * preorder on each node finding the counts that equals to the sum
 * the return the count and sum up the counts then is result
 * O(n^2)
 * Space constant
 */
public class PathSumIII {
	public PathSumIII() {}
	
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return findSum(root,sum) + pathSum(root.left,sum) + pathSum(root.right, sum);
    }
    
    private int findSum(TreeNode root, int sum){
        if(root == null) return 0;
        int count = 0;
        sum -= root.val;
        if(sum == 0) count++;;
        count += findSum(root.left,sum);
        count += findSum(root.right,sum);
        
        return count;
    }
}
