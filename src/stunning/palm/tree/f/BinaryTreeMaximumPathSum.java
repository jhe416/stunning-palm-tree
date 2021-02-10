package stunning.palm.tree.f;

import stunning.palm.tree.util.TreeNode;

/*
 * return one of the following through post order traverse
 * 1. total from the left node
 * 2. total from the right node
 * 3. root only, if root value is the max 
 * store the following through every level of post order traverse:
 * 1. left sum
 * 2. right sum
 * 3. path from right to root to left
 * 4. root if root is the max amount the above 3;
 * Time O(n)
 * Space O(n)
 */
public class BinaryTreeMaximumPathSum {
    private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return sum;
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum1 = left + right + root.val;
        int sum2 = left + root.val;
        int sum3 = right + root.val;
        sum = Math.max(sum,Math.max(sum1,Math.max(sum2,Math.max(root.val,sum3))));

        return Math.max(sum2,Math.max(sum3,root.val));
    }
}
