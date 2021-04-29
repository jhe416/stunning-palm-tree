package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.List;

/*
 * buble sort, swap max to the last index, by reverse to the first then reverse to the last
 * O(n^2)
 */
public class PancakeSorting {
	public PancakeSorting() {}
	
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for(int i=arr.length-1;i>=0;i--){
            int max = arr[i];
            int index = i;
            for(int j=0;j<=i;j++){
                if(arr[j] > max){
                    max = arr[j];
                    index = j;
                }
            }
            
            reverse(arr,index+1);
            res.add(index+1);
            reverse(arr,n);
            res.add(n--);
        }
        
        return res;
    }
    
    private void reverse(int[] arr, int k){
        int l =0, r = k-1;
        
        while(l<r){
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}
