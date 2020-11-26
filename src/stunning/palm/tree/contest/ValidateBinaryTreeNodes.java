package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * 1. build a graph and do a pre order travse on the graph and then see if all nodes are traversed
 * 2. during preorder traverse checking if the traverse node is hitting a visiting node if so then we know this is not a binary tree
 * 3. corner case handling that we need to find root, root property is it has no parent. so we use a set to remove any childern
 * then the ones left are the roots.
 * 
 * a nicer solution would be not building the graph but just use the input params which results the the complexity to be space constant
 * Time O(n)
 */
public class ValidateBinaryTreeNodes {
  //first solution
    public boolean validateBinaryTreeNodesSol1(int n, int[] leftChild, int[] rightChild) {
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> root = new HashSet<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            root.add(i);
        }
        
        for(int i=0;i<n;i++){
            graph.get(i).add(leftChild[i]);
            graph.get(i).add(rightChild[i]);
            root.remove(leftChild[i]);
            root.remove(rightChild[i]);
        }
        
        //if we have no root or more than one root we return false;
        if(root.size() == 0 || root.size() > 1) return false;
        
        int[] visited = new int[n];
        
        if(!traverseGraphSo1(root.stream().findFirst().get(),graph,visited)) return false;
        
        for(int val : visited){
            if(val != 1) return false;
        }
        
        return true;
    }
    
    private boolean traverseGraphSo1(int n, List<List<Integer>> graph, int[] visited){
        if(visited[n] != 0){
            return false;
        }
        
        visited[n] = 1;
        for(Integer val : graph.get(n)){
            if(val == -1) continue;
            if(!traverseGraphSo1(val,graph,visited)) return false;
        }
        
        return true;
    }
    
    //solution two no build graph
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> root = new HashSet<>();
        for(int i=0;i<n;i++){
            root.add(i);
        }
        
        for(int i=0;i<n;i++){
            root.remove(leftChild[i]);
            root.remove(rightChild[i]);
        }
        
        //if we have no root or more than one root we return false;
        if(root.size() == 0 || root.size() > 1) return false;
        
        int[] visited = new int[n];
        
        if(!traverseGraph(root.stream().findFirst().get(), leftChild, rightChild, visited)) return false;
        
        for(int val : visited){
            if(val != 1) return false;
        }
        
        return true;
    }
    
    private boolean traverseGraph(int n, int[] leftChild, int[] rightChild, int[] visited){
        if(visited[n] != 0){
            return false;
        }
        
        visited[n] = 1;
        int left = leftChild[n];
        if(left != -1 && !traverseGraph(left,leftChild,rightChild,visited)) return false;
        int right = rightChild[n];
        if(right != -1 && !traverseGraph(right,leftChild,rightChild,visited)) return false;
        
        return true;
    }
}
