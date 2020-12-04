package stunning.palm.tree.a;

import stunning.palm.tree.util.TreeNode;

/*
 * basically using post order to find average on each subtree and return the max..
 * post order allows you to traverse each sub tree and find its average and we just have to keep the max
 * Time O(n)
 * Space O(n)
 */
public class MaximumAverageSubtree {
	public MaximumAverageSubtree() {}
	
    private double max = 0;
    public double maximumAverageSubtree(TreeNode root) {
        findAverage(root);
        return max;
    }
    
    private double[] findAverage(TreeNode node){
        if(node == null) return new double[]{0,0};
        
        double[] left = findAverage(node.left);
        double[] right = findAverage(node.right);
        double sum = left[0] + right[0] + node.val;
        double count = left[1] + right[1] + 1;
        max = Math.max(max,sum/count);
        
        return new double[]{sum,count};
    }
}
