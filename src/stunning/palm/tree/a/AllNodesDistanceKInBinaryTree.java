package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import stunning.palm.tree.util.TreeNode;

/*
 * first build the bi directional graph and then do bfs on the target node
 * Time O(n)
 * Space O(n)
 */
public class AllNodesDistanceKInBinaryTree {
	public AllNodesDistanceKInBinaryTree() {}
	
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        initGraph(root); 
        buildGraph(root);
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        q.offer(target);
        set.add(target);
        
        int d = 0;
        while(!q.isEmpty() && d < K){
            for(int i=q.size(); i>0; i--){
                TreeNode node = q.poll();
                for(TreeNode child : graph.get(node)){
                    if(set.contains(child)) continue;
                    set.add(child);
                    q.offer(child);
                }
            }
            d++;
        }
        
        return q.stream().map(i->i.val).collect(Collectors.toList());
    }
    
    private void initGraph(TreeNode root){
        if(root == null) return;
        
        graph.put(root, new ArrayList<>());
        initGraph(root.left);
        initGraph(root.right);
    }
    
    private void buildGraph(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            graph.get(root).add(root.left);
            graph.get(root.left).add(root);
        }
        
        if(root.right != null){
            graph.get(root).add(root.right);
            graph.get(root.right).add(root);
        }
        buildGraph(root.left);
        buildGraph(root.right);
    }
}
