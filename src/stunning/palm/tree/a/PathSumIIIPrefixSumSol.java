package stunning.palm.tree.a;

import java.util.HashMap;
import java.util.Map;

import stunning.palm.tree.util.TreeNode;

/*
 * prefix sum solution, use currSum - sum to find the previous stored currSum if is found then we have found the path(or paths)
 * key is to remove the currSum after return of the preOrder, this way the prefix sum that does not belong to the current downstream will
 * not be count towards the result;
 * Time O(n)
 * Space O(n)
 */
public class PathSumIIIPrefixSumSol {
	public PathSumIIIPrefixSumSol() {}
	
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> map = new HashMap<>();
        return preOrder(map, root, sum, 0);
    }
    
    private int preOrder(Map<Integer,Integer> map, TreeNode root, int sum, int currSum){
        if(root == null) return 0;
        
        currSum += root.val;
        int count = 0;
        if(currSum == sum) count++;
        
        count += map.getOrDefault(currSum - sum, 0);
        
        map.put(currSum, map.getOrDefault(currSum,0)+1);
        
        count += preOrder(map,root.left,sum,currSum);
        count += preOrder(map,root.right,sum,currSum);
        
        map.put(currSum, map.get(currSum)-1);
        
        return count;
    }
}
