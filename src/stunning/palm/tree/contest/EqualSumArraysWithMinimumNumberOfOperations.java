package stunning.palm.tree.contest;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * Greedy, always increase max or decrease max until we find that sum1 >= sum2
 * see explation below
 * Time O(nlogn)
 * space constant
 */
public class EqualSumArraysWithMinimumNumberOfOperations {
	public EqualSumArraysWithMinimumNumberOfOperations() {}
	
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length * 6 < nums2.length || nums2.length*6 < nums1.length) return -1;
        
        int sum1 = IntStream.of(nums1).sum();
        int sum2 = IntStream.of(nums2).sum();
        if(sum1 > sum2) return minOperations(nums2,nums1);
        
        Arrays.sort(nums1); Arrays.sort(nums2);
        int i=0, j=nums2.length-1, res=0;
        
        //this is classic greedy that, each time we either increase the max on the smaller sum or decrase the max on the larger sum
        //we can do this by sort nums1 acsending, nums2 descending. so when we want to get the max on the smaller num1 we increse the smallest
        //index at the time to max 6 or we decrease the larger sum num2's largest index(descend sort) to 1 and see which one operation perform above
        // have the highest diff, that will be the operation we will pick
        //this process continuesl until sum1 is >= sum2. then we know the last operation can either give us an equal sum or we just have to adjust 
        //the operation to a proper value to make it equal
        while(sum1<sum2){
            int val1 = i<nums1.length? nums1[i] : Integer.MAX_VALUE;
            int val2 = j>=0? nums2[j] : Integer.MIN_VALUE/2;
            
            if(6-val1 > val2-1){
                sum1 += 6-val1;
                i++;
            }else{
                sum2 -= val2-1;
                j--;
            }
            res++;
        }
        
        return res;
    }
    
    /*
     * based on the above logic, instead of sort which will produce a nlog(n) result
     * we can keep a counter on the max diff produced from 5 to 1 and add them to sum1 until sum1 >= sum2;
     * note sum1 is always the smaller one
     * 
     * the reason for this is because instead of minus on sum2, the minus part can simply be added on top of the sum1 to even this out
     * a = b -c  -> a + c = b
     * Time O(n)
     * space constant
     */
    public int minOperationsSolTwo(int[] nums1, int[] nums2) {
        if(nums1.length * 6 < nums2.length || nums2.length*6 < nums1.length) return -1;
        
        int sum1 = 0;
        for(int i=0;i<nums1.length;i++) sum1+=nums1[i];
        int sum2 = 0;
        for(int i=0;i<nums2.length;i++) sum2+=nums2[i];
        if(sum1 > sum2) return minOperations(nums2,nums1);
        
        int[] count = new int[6];
        for(int i=0;i<nums1.length;i++) count[6-nums1[i]]++;
        for(int i=0;i<nums2.length;i++) count[nums2[i]-1]++;
        
        //i is the biggest diff
        int i=5, res = 0;
        while(sum1<sum2){
            if(count[i] == 0){
                i--;
                continue;
            }
            sum1+=i;
            count[i]--;
            res++;
        }
        
        return res;
    }
}
