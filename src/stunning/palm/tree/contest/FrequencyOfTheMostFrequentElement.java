package stunning.palm.tree.contest;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
	public FrequencyOfTheMostFrequentElement() {}
	
    //find the window that satisifies this condition: sum+k >= max * size
    public int maxFrequency(int[] nums, long k) {
        if(nums.length == 1) return 1;
        Arrays.sort(nums); //sorting the arr so we know each arr loop we are getting the max.
        int i=0,res=0;
        long sum=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            //if the sum of the window + k is greater than the max value of the window * the size then we know we can make the elements in the window the same within k operations
            while(sum+k<(long)nums[j]*(j-i+1)){
                sum-=nums[i];
                i++;
            }
            res = Math.max(res,j-i+1);
        }
        
        return res;
    }
}
