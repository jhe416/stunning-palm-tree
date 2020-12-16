package stunning.palm.tree.contest;

/*
 * this solution basically taking the description of the question literally,
 * using recursion and a 4d cache, the cache stores [each player][stones l][stones r][alice score and bob score]
 * each recursion we find out alice's maximum difference to bob's score and bob's minimum score to alice using the last new int[2] scores.
 * and we store the result to cache with the player tag. 
 * Time O(n^2)
 * Space O(n)
 */
public class StoneGameVII {
	public StoneGameVII() {}
	
    int[][][][] cache;
	public int stoneGameVII(int[] stones) {
		
		int[] sums = new int[stones.length+1]; // this is the prefic sum used to finding the sum when l, r is removed. 
	    for(int i=1;i<sums.length;i++){
	        sums[i] = sums[i-1] + stones[i-1];
	    }
	    
	    this.cache = new int[2][sums.length][sums.length][2];
	    int[] res = minMax(sums,1,sums.length-1,0,0);
	    
	    return res[0] - res[1];
	}
    
    private int[] minMax(int[] sums, int l, int r, int player, int sum){//index 0 is alice, 1 is bob
        if(l>=r) return new int[2];
        
        if(cache[player%2][l][r][0] != cache[player%2][l][r][1] || cache[player%2][l][r][0] != 0) return cache[player%2][l][r];
        
        int sum1 = sums[r] - sums[l];    
        int[] score1 = minMax(sums, l+1,r,player+1,sum1);
        
        int sum2 = sums[r-1] - sums[l-1];
        int[] score2 = minMax(sums,l,r-1,player+1,sum2);
        
        int index = player%2;
        if(index == 0){
            if(score1[0] + sum1 - score1[1] - sum > score2[0] + sum2 - score2[1] - sum){
                score1[index] += sum1;
                cache[index][l][r] = new int[]{score1[0],score1[1]};
                return score1;
            }else{
                score2[index] +=sum2;
                cache[index][l][r] = new int[]{score2[0],score2[1]};
                return score2;
            }
        }else{
            if(score1[0] + sum - score1[1] - sum1 > score2[0] + sum - score2[1] - sum2){
                score2[index] += sum2;
                cache[index][l][r] = new int[]{score2[0],score2[1]};
                return score2;
            }else{
                score1[index] += sum1;
                cache[index][l][r] = new int[]{score1[0],score1[1]};
                return score1;
            }   
        }
    }
}
