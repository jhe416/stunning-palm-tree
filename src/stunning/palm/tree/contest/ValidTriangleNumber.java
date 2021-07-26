package stunning.palm.tree.contest;

import java.util.Arrays;

/*
 * sort and then using binary search.
 * sort because once sort when c+b > a, c+a > b is always maintained.
 * we then use binary search find out the number of elements c where that a+b > c
 * Time O(n^2 * log(n))
 * space constant
 */
public class ValidTriangleNumber {
	public ValidTriangleNumber() {}
	
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int sum = nums[i] + nums[j];
                int l=j+1,r=nums.length-1;

                while(l<r){
                    int mid = l + (r-l)/2;
                    if(nums[mid] < sum){
                        l = mid+1;
                    }else{
                        r = mid;
                    }
                }
                res += nums[l] < sum? (l-j): (l-j-1);
            }
        }
        
        return res;
    }
}
