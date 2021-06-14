package stunning.palm.tree.u;

import java.util.Arrays;

//union find
//Time O(m*log(n)) m being the number of edges
//space O(n)
public class GraphValidTree {
	public GraphValidTree() {}
	
    public boolean validTree(int n, int[][] edges) {
        int[] arr = new int[n];
        Arrays.fill(arr,-1);
        for(int[] edge : edges){
            int sub1 = find(arr,edge[0]);
            int sub2 = find(arr,edge[1]);
            
            if(sub1 == sub2) return false;
            //union
            arr[sub1] = sub2;
        }
        
        int count =0;
        for(int val : arr){
            if(val == -1) count++;
            if(count>1) return false; 
        }
        
        return true;
    }
    
    public int find(int[] arr, int val){
        if(arr[val] == -1) return val;
        return find(arr,arr[val]);
    }
}
