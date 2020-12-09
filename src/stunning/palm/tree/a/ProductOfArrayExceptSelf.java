package stunning.palm.tree.a;

/*
 * pretty simple logic..going from left to right and store products before the index, special case here index 0 is 1
 * then going from right to left. store the product to the right before the index, special case here the last index no change
 * Time O(n)
 * space constant
 */
public class ProductOfArrayExceptSelf {
	public ProductOfArrayExceptSelf() {}
	
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        res[0] = 1;
        
        int product = nums[0];
        for(int i=1;i<nums.length;i++){
            res[i] = product;
            product*=nums[i];
        }
        
        product = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            res[i] *= product;
            product *= nums[i];
        }
        
        return res;
    }
}
