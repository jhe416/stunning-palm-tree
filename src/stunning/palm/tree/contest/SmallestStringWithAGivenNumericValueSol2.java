package stunning.palm.tree.contest;

/*
 * from left to right try to fill the pos of by following the 2 cases:
 * if k > remaining pos*26 meaning we can field the rest at 'z' so the current post would be 
 * k-26 * remaining position, otherwise the current position is 'a' 
 * see leetcode solution
 * Time O(n) space constant
 */
public class SmallestStringWithAGivenNumericValueSol2 {
	public SmallestStringWithAGivenNumericValueSol2() {}
	
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for(int i=0;i<n;i++){
            //case 1 k greater than remaining pos
            if(k>(n-1-i)*26){
                result[i] = (char)('a' + k-(n-1-i)*26 -1);
                k-=k-(n-1-i)*26;
            }else{ //case 2 fill the current with remaining k
                result[i] = 'a';
                k--;
            }
        }
        
        return new String(result);
    }
}
