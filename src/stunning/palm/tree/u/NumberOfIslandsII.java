package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * union find, when two island encountered we union
 * decrement the count
 * Time O(m*logn) n being the length of arr m being the number of positions
 * Space O(n) n being n*m
 *  
 */
public class NumberOfIslandsII {
	public NumberOfIslandsII() {}
	
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] arr = new int[m*n];
        Arrays.fill(arr,-1);
        List<Integer> res = new ArrayList<>();
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        int count = 0;
        for(var pos : positions){
            int root = n*pos[0] + pos[1];
            if(arr[root] != -1){
                res.add(count);
                continue;
            }
            arr[root] = root;
            count++;
            for(int[] dir : dirs){
                int i = pos[0] + dir[0];
                int j = pos[1] + dir[1];
                int newRoot = n*i+j;
                if(i<0 || i==m || j<0 || j==n || arr[newRoot] == -1) continue;
                newRoot = find(arr,newRoot);
                //union
                if(newRoot != root){
                    arr[root] = newRoot;
                    root = newRoot;
                    count--;                    
                }
            }
            res.add(count);
        }
        
        return res;
    }
    
    public int find(int[] arr, int val){
        if(arr[val] == val) return val;
        return find(arr,arr[val]);
    }
}
