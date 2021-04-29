package stunning.palm.tree.a;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import stunning.palm.tree.util.TreeNode;

/*
 * stack solution, when array reaches to the inorder point, stack pop to the turning point and the extend right left
 * then continue left until inorder point meet again
 * every pop inorder traverse increments
 * the stack push is the preorder traverse while the stack pop is the inroder traverse
 * Time O(n)
 * Space O(n)
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public ConstructBinaryTreeFromPreorderAndInorderTraversal() {}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        TreeNode res = root;
        int j =0;
        for(int i=1;i<preorder.length;i++){
            if(j<inorder.length && stack.peek().val == inorder[j]){
                while(!stack.isEmpty() && j<inorder.length && stack.peek().val == inorder[j]){
                    root = stack.pop();
                    j++;
                }
                root.right = new TreeNode(preorder[i]);
                root = root.right;
            }else{
                root.left = new TreeNode(preorder[i]);
                root = root.left;
            }
            stack.push(root);
        }
        
        return res;
    }
    
    /*
     * solution two, divide and conquer.
     * find the root and the inorder's left and right
     * finding the new root by pstart+1 on left interval of inorder, and pstart+(i-istart)+1 on the right interval of inorder(the first node index on the right interval)
     * Time O(n)
     * Space O(n)
     */
    public TreeNode buildTreeSolTwo(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(map,0,0,inorder.length-1,preorder,inorder);
    }
    
    private TreeNode helper(Map<Integer,Integer> map, int pstart, int istart, int iend, int[] preorder, int[] inorder){
        if(pstart == preorder.length || istart>iend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        
        int i = map.get(preorder[pstart]);
        root.left=helper(map,pstart+1,istart,i-1,preorder,inorder);
        root.right=helper(map,pstart+i-istart+1,i+1,iend,preorder,inorder);
        return root;
    }
}
