package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.List;

/*
 * our task in this binary search is to find the start of sliding window so that it's middle is the closest to x.
 * Time O(log(n-k)
 * space constant
 */
public class FindKClosestElementsTwo {
	public FindKClosestElementsTwo() {}
	
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0) return res;
        if(arr.length == k){
            for(int val : arr){
                res.add(val);
            }
            return res;
        }
        
        int l = 0, r = arr.length-k;
        while(l<r){
            int mid = l + (r-l)/2;
            //x - A[mid] > A[mid + k] - x think in terms of midpoint of the two values x > (A[mid + k] + A[mid])/2.
            if(x - arr[mid] > arr[mid+k] - x){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        
        for(int i=l;i<l+k;i++) res.add(arr[i]);
        return res;
    }
}
