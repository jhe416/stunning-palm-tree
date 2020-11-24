package stunning.palm.tree.a;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * define a sort either on the priority queue or just sort the given array and pick the first k
 */
public class KClosestPointsToOrigin {
	public KClosestPointsToOrigin() {}
	
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> ((a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1])));
        for(int[] point : points){
            q.offer(point);
            //if(q.size() > k) q.poll();
            
        }
        int[][] res = new int[k][2];
        
        for(int i=0;i<k;i++){
            int[] val = q.poll();
            res[i][0] = val[0];
            res[i][1] = val[1];
        }
        return res;
    }
    
    public int[][] kClosestSolTwo(int[][] points, int k) {
        Arrays.sort(points,(a,b)->{
        	return a[0]*a[0]+a[1]*a[1] < b[0]*b[0]+b[1]*b[1]? -1 : 1;
        });
        int[][] res = new int[k][2];
        
        for(int i=0;i<k;i++){
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
}
