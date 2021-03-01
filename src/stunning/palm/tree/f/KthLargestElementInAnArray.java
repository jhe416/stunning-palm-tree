package stunning.palm.tree.f;

/*
 * divide and conquer with quick sort
 */
public class KthLargestElementInAnArray {
	public KthLargestElementInAnArray() {}
	
	  public int findKthLargest(int[] nums, int k) {
	        return helper(0,nums.length-1,nums,k);
	    }
	    
	    private int helper(int l, int r, int[] nums, int k){
	        if(l>r) return 0;
	        int index = quickSort(nums,l,r);
	        if(index == nums.length-k) return nums[index];
	        
	        if(index > nums.length - k){
	            return helper(l,index-1,nums,k);
	        }else{
	            return helper(index+1,r,nums,k);
	        }
	    }
	    
	    private int quickSort(int[] nums, int l, int h){
	        int pivot = nums[h];
	        
	        int j=l;
	        for(int i=l;i<=h;i++){
	            if(nums[i] <= pivot){
	                swap(nums,i,j);
	                j++;
	            }
	        }
	        return j-1;
	    }
	    
	    private void swap(int[] nums, int i ,int j){
	        int tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] =tmp;
	    }
}
