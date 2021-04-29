package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import stunning.palm.tree.util.TreeNode;

/*
 * once all vertical nodes are collected just sorted them by row if some of them happy to be in the same row
 * and everything else stays in the same position
 * Time O(nlogn) Space(n) 
 */
public class VerticalOrderTraversalOfABinaryTree {
	public VerticalOrderTraversalOfABinaryTree() {}
	
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int min = 0, max = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        q.offer(root); levels.offer(0);
        
        Map<Integer,List<int[]>> map = new HashMap<>();
        int row = 0;
        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                TreeNode node = q.poll();
                int level = levels.poll();
                
                List<int[]> list = map.getOrDefault(level,new ArrayList<>());
                list.add(new int[]{node.val,row});
                map.putIfAbsent(level,list);
                
                if(node.left!=null){
                    min = Math.min(min,level-1);
                    levels.offer(level-1);
                    q.offer(node.left);
                }
                
                if(node.right != null){
                    max = Math.max(max,level+1);
                    levels.offer(level+1);
                    q.offer(node.right);
                }    
            }
            row++;
        }
        
        for(int i=min;i<=max;i++){
            List<int[]> list = map.get(i);
            List<Integer> vals = new ArrayList<>();
            if(list.size() == 1){
                vals.add(list.get(0)[0]);
            }else{
                Collections.sort(list,(a,b) -> (a[1]==b[1]? a[0]-b[0] : 0));
                for(int[] val : list){
                    vals.add(val[0]);
                }
            }
            res.add(vals);
        }
        
        return res;
    }
}
