package stunning.palm.tree.u;

/*
 * find the max saved grumpy window and save the interval
 * then count the satisfied customer with the grumpy days exclude the interval
 * Time O(n)
 * space constant
 */
public class GrumpyBookstoreOwner {
	public GrumpyBookstoreOwner() {}
	
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        if(customers.length == 0) return 0;
        int i=0;
        int sum = 0, max = Integer.MIN_VALUE;
        int[] interval = new int[2];
        for(int j=0;j<customers.length;j++){
            sum+=grumpy[j] == 1? customers[j] : 0;
            while(x<j-i+1){
                sum-=grumpy[i] == 1? customers[i] : 0;
                i++;
            }
            
            if(max < sum){
                interval = new int[]{i,j};
                max = sum;
            }
        }
        
        int res = 0;
        for(int j=0;j<customers.length;j++){
            if((j>=interval[0] && j<=interval[1]) || grumpy[j] == 0) res+=customers[j];
        }
        
        
        return res;
    }
}
