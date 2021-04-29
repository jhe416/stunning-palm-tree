package stunning.palm.tree.contest;

/*
 * basically recursion finding all remainder sum
 */
public class SumOfDigitsInBaseK {
	public SumOfDigitsInBaseK() {}
	
    public int sumBase(int n, int k) {
        int val = n/k;
        int r = n%k;
        if(val == 0) return r;
        
        return sumBase(val,k) + r;
    }
}
