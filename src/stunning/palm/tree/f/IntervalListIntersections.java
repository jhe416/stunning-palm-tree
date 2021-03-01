package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.List;

/*
 * catch up between index1 and index2
 * once catched up either interval1's end is greater or interval2's end is greater
 * then just handle two cases if the start is inside or not the bigger end interval
 * increment the smaller end;
 * Time o(N)
 * space constant
 */
public class IntervalListIntersections {
	public IntervalListIntersections() {}
	
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0) return new int[0][0];
        
        List<int[]> list = new ArrayList<>();
        
        int index1 =0, index2 =0;
        
        while(index1<firstList.length && index2<secondList.length){
            int[] interval1 = firstList[index1];
            int[] interval2 = secondList[index2];
            
            if(interval1[1] < interval2[0]){
                index1++;
            }else if(interval2[1] < interval1[0]){
                index2++;
            }else if(interval1[1] > interval2[1]){
                if(interval2[0] >= interval1[0]){
                    list.add(interval2);
                }else{
                    list.add(new int[]{interval1[0],interval2[1]});
                }
                index2++;
            }else{
                if(interval1[0] >= interval2[0]){
                    list.add(interval1);
                }else{
                    list.add(new int[]{interval2[0], interval1[1]});
                }
                index1++;
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}
