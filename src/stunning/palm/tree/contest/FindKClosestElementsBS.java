package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.List;

/*
 * first binary search finding the closet element index to x
 * then expand the window around the index x until the k is found
 * Time O(n)
 * Space constant
 */
public class FindKClosestElementsBS {
	public FindKClosestElementsBS() {}
	
    //Every time you see a problem that involves a sorted array, you should consider binary search.
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(k == arr.length){
            for(int val : arr) res.add(val);
            return res;
        }
        
        int l=0, r=arr.length-1, n=arr.length;
        while(l<r){
            int mid = l + (r-l)/2;
            if(arr[mid] >= x){
                r=mid;
            }else{
                l=mid+1;
            }
        }

        /*
         * using a two pointers to form a bound.
         * i and j here is the boundary exclusive!
         */
        int i = l-1;
        int j = l;
        while(j-i-1 < k){
            if(i<0){
                j++;
            }else if(j==n){
                i--;
            }else{
                if(Math.abs(arr[i]-x) < Math.abs(arr[j] -x)){
                    i--;
                }else if(Math.abs(arr[i]-x) > Math.abs(arr[j] -x)){
                    j++;
                }else{
                    if(arr[i]<arr[j]) i--;
                    else j++;
                }
            }

        }
        
        for(int z=i+1;z<j;z++)res.add(arr[z]);
        
        return res;
    }
}
