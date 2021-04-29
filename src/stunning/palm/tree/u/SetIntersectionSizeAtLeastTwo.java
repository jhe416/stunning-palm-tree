package stunning.palm.tree.u;

import java.util.Arrays;

/*
 * sort the given intervals, greedy approach 
 * 1. greedy, starting from the last interval and picking the s, and s+1 as they will provide the most possible coverage
 * 2. once picked then loop from the beginning and checking if each interval has the picked s covered. if so decrement the interval's count since we have found one coverage for the interval
 * 3. skip the interval if the interval has 0 count as Ss found from previous will cover this interval
 * 4. special case handle when starting is the same
 * 	  - sort the ending in descending order, for example (2,4) (2,3) this way after solving (2,3), (2,4) will be covered. this will genereated the max possible coverage
 * Time O(n^2)
 * Space O(n)
 */
public class SetIntersectionSizeAtLeastTwo {
	public SetIntersectionSizeAtLeastTwo() {}
	
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0] != b[0]? a[0]-b[0] : b[1] - a[1])); //the b[1] - a[1] is there to handle special case
        int[] count = new int[intervals.length];
        Arrays.fill(count,2);
        int res = 0;
        for(int i=intervals.length-1;i>=0;i--){
            int s = intervals[i][0];
            int m = count[i];
            for(int j=s;j<s+m;j++){
                for(int k=0;k<i;k++){
                    if(count[k]>0 && intervals[k][1] >= j){
                        count[k]--;
                    }
                }
                res++;
            }
        }
        
        return res;
    }
}
