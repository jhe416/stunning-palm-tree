package stunning.palm.tree.f;

import java.util.LinkedList;
import java.util.Queue;

import stunning.palm.tree.util.TreeNode;

/*
 * encode preorder
 * decode preorder using queue
 * Time O(n)
 * Space O(n)
 */
public class SerializeAndDeserializeBinaryTree {
	public SerializeAndDeserializeBinaryTree() {}
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        
        return sb.toString();
    }
    
    private void helper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null").append(",");
            return;
        }
        
        sb.append(root.val).append(",");
        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(String str : arr){
            if(str == null || str.isBlank()) continue;
            q.offer(str);
        }
        
        return decode(q);
    }
    
    private TreeNode decode(Queue<String> q){
        if(q.isEmpty()) return null;
        String str = q.poll();
        if(str.equals("null")) return null;
        
        TreeNode root= new TreeNode(Integer.valueOf(str));
        root.left=decode(q);
        root.right=decode(q);
            
        return root;
    }
}
