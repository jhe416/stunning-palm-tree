package stunning.palm.tree.contest;

import java.util.Arrays;

/*
 * hmmm..nothing to say
 * but java 8 solution tho. super sick
 */
public class RichestCustomerWealth {
	public RichestCustomerWealth() {}
	
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int m =accounts.length;
        int n =accounts[0].length;
        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                sum+=accounts[i][j];
            }
            max = Math.max(max,sum);
        }
        
        return max;
    }
    
    public int richestCustomerWealthSol2(int[][] accounts) {
    	return Arrays.stream(accounts).mapToInt(i -> Arrays.stream(i).sum()).max().getAsInt();
    }
}
