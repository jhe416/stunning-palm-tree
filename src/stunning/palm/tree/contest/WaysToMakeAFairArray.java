package stunning.palm.tree.contest;

/*
 * Let's take an example :
Array = [6,1,7,4,1]
In the above array sum = 19 (6+1+7+4+1) , evenIndexSum = 14 (6+7+1) , oddIndexSum = 5 (1+4)

step1 : remove first element 6 --> array becomes [1,7,4,1] --> sum = 13, evenIndexSum=5 , oddIndexSum = 8
Step 2 : remove 1 -->array = [6,7,4,1] --> sum = 18 , evenIndexSum=10,oddIndexSum = 8
step 3 : remove 7 -->array = [6,1,4,1]-->sum = 12 , evenIndexSum=10,odd=2
step 4: remove 4-->array = [6,1,7,1] --> sum= 15, evenIndexSum = 13, oddIndexSum=2
step5 : remove 1 --> array = [6,1,7,4]--> sum=18, evenIndexSum = 13, oddIndexSum =5

If we observe this pattern closley ,
for odd iteration --> oddSum is not changing from previous step
for even Iteration --> evenSum is not changing from previous step
Time O(n) Space constant
 */
public class WaysToMakeAFairArray {
	public WaysToMakeAFairArray() {}
	
    public int waysToMakeFair(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 1) return 1;
        if(nums.length < 3) return 0;
      
        int sum=0, oddsum = 0, evensum=0;
         //init the first odd even sum by removing the first index
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i==0)continue;
            else if(i%2 == 0) oddsum+=nums[i];
            else evensum+=nums[i];
        }
        
        int res = evensum == oddsum? 1 : 0;
        
        for(int i=1;i<nums.length;i++){
            int tmpSum = sum - nums[i];
            //when removing the even index I take the previous even
            if(i%2 == 0){
                oddsum = tmpSum - evensum;
            }else{ // when removing the odd index I take the odd index
                evensum = tmpSum - oddsum;
            }
            
            res += evensum == oddsum? 1 : 0;
        }
        return res;
    }
}
