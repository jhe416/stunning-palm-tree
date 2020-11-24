package stunning.palm.tree.contest;

/*
 * greedy solution, loop from back to front and try to fill the position with the z, not enough k, try to fill k with the remaning k
 * Time O(n)
 * Space constant
 * check the leet code solution for detail. 
 */
public class SmallestStringWithAGivenNumericValueSol1 {
	public SmallestStringWithAGivenNumericValueSol1() {}
	
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for(int p=n-1; p>=0; p--){
            int add = Math.min(k-p,26);//here k-p meaning after filling p position whats the remaining of k
            result[p] = (char)('a' + add - 1);
            k-=add;
        }
        
        return new String(result);
    }
}
