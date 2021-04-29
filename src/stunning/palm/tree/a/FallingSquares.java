package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.List;

public class FallingSquares {
	public FallingSquares() {}
	
    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();        
        int maxH = positions[0][1];
        List<Integer> res = new ArrayList<>();
        res.add(maxH);
        intervals.add(new Interval(positions[0][0],positions[0][0] + positions[0][1], maxH));
        for(int i=1;i<positions.length;i++){
            int s = positions[i][0];
            int h = positions[i][1];
            int e = s + h;
            int maxIntervalHeight = 0;
            for(Interval interval : intervals){
                if(s >= interval.end || e<=interval.start) continue;
                maxIntervalHeight = Math.max(maxIntervalHeight,interval.height);
            }
            intervals.add(new Interval(s,e,maxIntervalHeight+h));
            maxH = Math.max(maxIntervalHeight+h,maxH);
            res.add(maxH);
            
        }
        
        return res;
    }
}

class Interval{
    public int start;
    public int end;
    public int height;
    
    public Interval(int start, int end, int height){
        this.start = start; this.end = end; this.height = height;
    }
}
