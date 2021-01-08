package stunning.palm.tree.contest;

/*
 * class min max solution with the cache to store l and r's difference
 * Time O(n^2)
 * Space O(n)
 * 
 */
public class StoneGame {
	public StoneGame() {}
	
    int[][] cache;
    public boolean stoneGame(int[] piles) {
        this.cache = new int[piles.length][piles.length];
        return miniMax(0, piles.length-1, piles, true) > 0;
    }
    
    private int miniMax(int l, int r, int[] piles, boolean isAlex){
        if(l > r) return 0;
        if(cache[l][r] > 0) return cache[l][r];
        int diff = 0;
        if(isAlex){
           diff = Math.max(piles[l] + miniMax(l+1,r,piles,false), piles[r] + miniMax(l,r-1,piles,false));
        }else{
           diff = Math.min(miniMax(l+1,r,piles,true) - piles[l], miniMax(l,r-1,piles,true) - piles[r]);
        }
        
        cache[l][r] = diff;
        return diff;
    }
}
