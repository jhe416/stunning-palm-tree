package stunning.palm.tree.f;

import java.util.Arrays;

/*
 * sort and return..
 */
public class KClosestPointsToOrigin {
	public KClosestPointsToOrigin() {}
	
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(a,b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        
        int[][] res = new int[k][2];
        
        for(int i=0;i<k;i++){
            res[i] = points[i];
        }
        
        return res;
    }
}
