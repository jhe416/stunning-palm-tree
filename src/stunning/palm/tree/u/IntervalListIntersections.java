package stunning.palm.tree.u;

//IntervalListIntersections
import java.util.ArrayList;
import java.util.List;

//IntervalListIntersections
public class IntervalListIntersections {
	public IntervalListIntersections() {}
	
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0,j=0;
        List<int[]> resList = new ArrayList<>();
        while(i<firstList.length && j<secondList.length){
            int[] first = firstList[i], second = secondList[j];
            if(first[1] >= second[0] && first[0] <= second[0]){
                resList.add(new int[]{second[0],Math.min(first[1],second[1])});
            }else if(second[1] >= first[0] && second[0] <= first[0]){
                resList.add(new int[]{first[0],Math.min(first[1],second[1])});
            }
            
            //always keep the longest ending for max coverage
            if(first[1] > second[1]){
                j++;
            }else{
                i++;
            }
        }
        
        return resList.toArray(new int[resList.size()][]);
    }
}
