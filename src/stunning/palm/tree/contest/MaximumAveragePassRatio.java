package stunning.palm.tree.contest;

import java.util.PriorityQueue;

/*
 * heap, sort the diff max on top and always add the extra student to the diff max class
 * Time O(nlog(n)) n is number of class
 * Space O(n)
 */
public class MaximumAveragePassRatio {
	public MaximumAveragePassRatio() {}
	
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> q = new PriorityQueue<>((a,b) -> {
            if(a[2] == b[2]) return 0;
            else if(a[2] < b[2]) return 1;
            else return -1;
        });
        
        for(int[] c : classes){
            double a = c[0], b = c[1];
            q.offer(new double[]{a,b,(a+1)/(b+1) - a/b});
        }
        
        double n = classes.length;
        int i = 1;
        while(i<=extraStudents){
            double[] c = q.poll();
            c[0] = c[0]+1;
            c[1] = c[1]+1;
            c[2] = (c[0]+1)/(c[1]+1) - c[0]/c[1];
            q.offer(c);
            i++;
        }
        double sum = 0;
        while(!q.isEmpty()){
            sum+=(q.peek()[0]/q.poll()[1]);
        }
        
        return sum/n;
    }
}
