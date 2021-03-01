package stunning.palm.tree.f;

public class ProductOfArrayExceptSelf {
	public ProductOfArrayExceptSelf() {}
	
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int p=1;
        for(int i=0;i<nums.length;i++){
            res[i] = p;
            p*=nums[i];
        }
        
        p=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] *=p;
            p*=nums[i];
        }
        
        return res;
    }
}
