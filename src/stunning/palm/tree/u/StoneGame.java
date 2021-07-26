package stunning.palm.tree.u;
//StoneGame
public class StoneGame {
	public StoneGame() {}
	
    Integer[][] cache;
    public boolean stoneGame(int[] piles) {
        this.cache = new Integer[piles.length][piles.length];
        return helper(piles,true,0,piles.length-1) > 0;
    }
    

    private int helper(int[] arr, boolean isAlex, int s, int e){
        if(s>e) return 0;
        if(cache[s][e] != null ) return cache[s][e];

        int val1 = helper(arr,!isAlex,s+1,e);
        int val2 = helper(arr,!isAlex,s,e-1);
        
        int res = isAlex? Math.max(val1+arr[s],val2+arr[e]) : Math.min(val1-arr[s],val2-arr[e]);
        cache[s][e] = res;
        return res;
    }
}
