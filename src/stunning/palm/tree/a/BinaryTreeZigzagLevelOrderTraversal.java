package stunning.palm.tree.a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import stunning.palm.tree.util.TreeNode;

/*
 * level order traverse on q and use ArrayDeque to determine addfirst or addlast depending on the level
 * Time O(n)
 * Space O(n)
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public BinaryTreeZigzagLevelOrderTraversal() {}
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        
        while(!q.isEmpty()){
            level++;
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i=q.size(); i>0;i--){
                TreeNode node = q.poll();
                if(level%2 == 0){
                    stack.addFirst(node.val);
                }else{
                    stack.addLast(node.val);
                }
                
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);   
            }
                            
            res.add(new ArrayList<>(stack));
        }
        
        return res;
    }
}
