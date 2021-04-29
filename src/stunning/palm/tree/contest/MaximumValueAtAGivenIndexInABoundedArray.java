package stunning.palm.tree.contest;

/*
 * binary search..0 to maxsum is the range pick a target max on the index and calculate the sum of the array
 * using math on both side, for example if index target at +5 left and right side becomes to +4, +3,+2,+1,1,1,1..
 * so this is 首项加末项乘以讲述除以二 on both side, the length can be determined for both left and right side by the given index
 * shrink the r to mid if bigger. increase l to mid+1 if smaller.
 * Time Olog(n) n is the maxSum
 * space constant
 */
public class MaximumValueAtAGivenIndexInABoundedArray {
	public MaximumValueAtAGivenIndexInABoundedArray() {}
	
	 public int maxValue(int n, int index, int maxSum) {
	        if(n*n<=maxSum) return n;
	        
	        int lenl = index - 0;
	        int lenr = n-1-index;
	        int l = 0;
	        int r = n-1;
	        int res = 0;
	        while(l<r){
	            int mid = l+(r-l)/2;
	            
	            int sum = 0;
	            
	            for(int i=1;i<=lenl;i++){
	                sum+=(mid-i);
	            }
	            
	            for(int i=1;i<=lenr;i++){
	                sum+=(mid-i);
	            }
	    
	            sum += mid;
	            
	            if(sum >maxSum){
	                r = mid;
	            }else{
	                res = Math.max(res,mid);
	                l = mid+1;
	            }
	            
	        }
	        
	        return res;
	    }
}
