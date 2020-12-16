package stunning.palm.tree.contest;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * the idea of this question is greedy:
 * Alice wants the max of its own score
 * but Alice also want bob to loss the max of bob's score
 * so we sort the sum between Alice[i] + bob[i] descending
 * so alice will pick its max and burn bob's max 
 * Time O(nlogn)
 * space O(n)
 */
public class StoneGameVI {
	public StoneGameVI() {}
	
    public int stoneGameVIHeap(int[] aliceValues, int[] bobValues) {
        int bob = 0, alice = 0;
        boolean isAlice = true;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        int n = aliceValues.length;
        for(int i=0;i<n;i++){
            q.offer(new int[]{aliceValues[i] + bobValues[i],i});
        }
        
        while(!q.isEmpty()){
            if(isAlice){
                alice += aliceValues[q.poll()[1]];
            }else{
                bob += bobValues[q.poll()[1]];
            }
            
            isAlice = !isAlice;
        }
        
        return alice == bob? 0 : alice > bob? 1 : -1;
    }
    
    public int stoneGameVIArray(int[] aliceValues, int[] bobValues) {
        int bob = 0, alice = 0;
        boolean isAlice = true;
        
        int n = aliceValues.length;
        int[][] sums = new int[n][2];
        for(int i=0;i<n;i++){
            sums[i] = new int[]{aliceValues[i]+bobValues[i],i};
        }
        
        Arrays.sort(sums,(a,b) -> (b[0] - a[0]));
        
        for(int i=0;i<n;i++){
            if(isAlice){
                alice += aliceValues[sums[i][1]];
            }else{
                bob += bobValues[sums[i][1]];
            }
            
            isAlice = !isAlice;
        }
        
        return alice == bob? 0 : alice > bob? 1 : -1;
    }
}
