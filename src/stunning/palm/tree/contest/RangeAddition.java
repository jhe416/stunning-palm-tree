package stunning.palm.tree.contest;

/*
 * mark the start as the sum and the end+1 the reset of the sum
 * Time O(n + k) where n is the length and k is number of intervals
 * Space constant
 */
public class RangeAddition {
	
	public RangeAddition() {}
	
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] vals : updates){
            res[vals[0]] += vals[2];
            if(vals[1] + 1 < length) res[vals[1]+1] -= vals[2];
        }
        
        int sum = 0;
        for(int i=0;i<res.length;i++){
            sum+=res[i];
            res[i]=sum;
        }
        
        return res;
    }
}
