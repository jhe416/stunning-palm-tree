package stunning.palm.tree.contest;

/*
 * my solution is basically count the number of times I have to minus on the deci binary number in order to make the n zero
 * another way to do this is basically find the max number in n and that is how many times need to make n zero
 * the max result is 9.
 * Time O(n)
 * Space constant
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
	public PartitioningIntoMinimumNumberOfDeciBinaryNumbers() {}
	
    public int minPartitions(String n) {
        char[] arr = n.toCharArray();
        int res = 0;
        boolean hasOne = true;
        while(hasOne){
            hasOne = false;
            for(int i=0;i<arr.length;i++){
                if(arr[i] > '0'){
                    arr[i]--;
                    res+= !hasOne? 1 : 0;
                    hasOne = !hasOne? true : hasOne;
                }
            }
        }
        
        return res;
    }
    
    public int minPartitionsAnotherSolution(String n) {
        char[] arr = n.toCharArray();
        int res = Integer.MIN_VALUE;
        
        for(char c : arr){
            res = Math.max(c-'0',res);
        }
        
        return res;
    }
}
