package stunning.palm.tree.contest;

import java.math.BigInteger;

public class ConcatenationOfConsecutiveBinaryNumbers {
	public ConcatenationOfConsecutiveBinaryNumbers() {}
	
	/*
	 * my soltuion bigInteger works but will timeout as the time limit is only 1.5s...
	 */
    public int concatenatedBinaryMuSol(int n) {
        BigInteger mod = new BigInteger("1000000007");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=n;i++){
            String bits = Integer.toBinaryString(i);
            sb.append(bits);
        }
        
        BigInteger res = new BigInteger(sb.toString(), 2);
        return res.mod(mod).intValue();
    }
    
    /*
     * the idea of this solution is always keep a left shift by 1 val on every bit.
     * when a bit == 1 we add val and keep shifting
     * while doing the adding the res and shift the val wo mod by 10^9+7 to avoid overflow
     * Time O(n) n being the number of bits.
     * Space constant
     */
    public int concatenatedBinary(int n) {
        int val = 1;
        int res = 0;
        int mod = 1000000007;
        for(int i=n;i>0;i--){
            int num = i;
            while(num>0){
                if((num&1) == 1){
                    res = (res + val)%mod;
                }
                val = (val << 1) % mod;
                num = num >> 1;
            }
        }
        
        return res;
    }
}
