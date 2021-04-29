package stunning.palm.tree.f;

/*
 * find the first small from right to left
 * find the first large that is larger than small index
 * swap the small and large
 * and swap everything after small (small+1)
 * Time O(n)
 * space constant
 */
public class NextPermutation {
	public NextPermutation() {}
	
    public void nextPermutation(int[] nums) {
        int small = -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                small = i;
                break;
            }
        }
        
        if(small == -1){
            int l=0;
            int r = nums.length-1;
            while(l<r){
                swap(l++,r--,nums);
            }
            return;
        }
        
        int large = nums.length-1;
        for(;large>small && nums[large] <= nums[small];large--){
        }
        swap(small,large,nums);
        int l = small+1;
        int r = nums.length-1;
        while(l<r){
            swap(l++,r--,nums);
        }
    }
    
    private void swap(int l, int r, int[] nums){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
    }
}
