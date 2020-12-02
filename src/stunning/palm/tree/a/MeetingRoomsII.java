package stunning.palm.tree.a;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * using a q to fetch the earliest ending class room and compare that to the current class room see if we can
 * re-use the class room in q, if so we pop
 * in the end we check the q.size() for the minimal class rooms required.
 * 
 * Time O(nlog(n))
 * Space O(n)
 */
public class MeetingRoomsII {
	public MeetingRoomsII() {}
	
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[1] == b[1]? a[0] - b[0] : a[1] - b[1]));
        Arrays.sort(intervals, (a,b) -> (a[0] == b[0]? a[1] - b[1] : a[0] - b[0]));
        for(int[] val : intervals){
            if(q.isEmpty()) q.offer(val);
            else{
                if(!q.isEmpty() && q.peek()[1] <= val[0]) q.poll();
                q.offer(val);
            }
        }
        
        return q.size();
    }
}
