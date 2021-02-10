package stunning.palm.tree.f;

/*
 * basically a insert target into sorted array question
 * Time O(logn)
 * space O(n)
 */
public class RandomPickWithWeight {
	private int[] sums;
    private int range;
    public RandomPickWithWeight(int[] w) {
        this.sums = new int[w.length];
        sums[0] = w[0];
        for(int i=1;i<w.length;i++){
            sums[i] = sums[i-1] + w[i];
        }
        
        this.range = sums[w.length-1];
    }
    
    public int pickIndex() {
        double val = range * Math.random();
        int l = 0, r = sums.length-1;
        
        while(l<r){
            int mid = l + (r-l)/2;
            if(val == sums[mid]) return mid;
            if(val>sums[mid] && mid+1 < sums.length && val < sums[mid+1]) return mid+1;
            if(val < sums[mid] && mid-1 >=0 && val > sums[mid-1]) return mid;
            
            if(sums[mid] < val){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        
        return l;
    }
}
