package stunning.palm.tree.contest;

/*
 * classic minimax solution Alice reaches to the maximum right and bob reaches the minimum left. 
 * Bob is the minimizer Alice is the maximizer. Imaging a line of differences where the original difference is at 0 (when recursion hits the end), 
 * each recursion, a new difference point is returned 
 * Bob as a minimizer tries to bring the difference to the far left(minimize) while Alice as the maximizer tries to bring the difference to the far right(maximize). 
 * So when there is a difference present, bob '-' the difference and the smallest is taken (line direction to the left). 
 * In contrast, Alice '+' and the largest is taken (line direction to the right). 
 * There are times when score difference can have negative differences(bob has more points than Alice, difference is on the left side of the line), 
 * but because Alice is 100p gonna win, the negative differences will later caught up by Alice from the maximizing.
 * 
 * Time O(n^2) 
 * Space O(n)
 */
public class StoneGameVIIMiniMaxSol {
	public StoneGameVIIMiniMaxSol() {}
	
    public int stoneGameVII(int[] stones) {
        int[] pSum = new int[stones.length+1];
        int n = pSum.length;
        for(int i=1;i<n;i++){
            pSum[i] = pSum[i-1] + stones[i-1];
        }
        
        int[][][] cache = new int[n][n][2];
        return minMax(cache,pSum,1,n-1,0);
    }
    
    private int minMax(int[][][] cache, int[] pSum, int l, int r, int player){
        if(l==r) return 0;
        if(cache[l][r][player] > 0) return cache[l][r][player];
        
        int suml = pSum[r] - pSum[l];
        int sumr = pSum[r-1] - pSum[l-1];
        
        int difference = 0;
        if(player == 0){
            difference = Math.max(minMax(cache, pSum, l+1, r, 1) + suml, minMax(cache, pSum, l, r-1, 1) + sumr);
        }else{
            difference = Math.min(minMax(cache, pSum, l+1, r, 0) - suml, minMax(cache, pSum, l, r-1, 0) - sumr);
        }
        
        cache[l][r][player] = difference;
        return difference;
    }
}
