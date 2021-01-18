package stunning.palm.tree.contest;

public class NumberOfRectanglesThatCanFormTheLargestSquare {
	public NumberOfRectanglesThatCanFormTheLargestSquare() {}
	
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        for(int[] val : rectangles){
            if(val[0] < val[1]){
                max = Math.max(max,val[0]);
            }else{
                max = Math.max(max,val[1]);
            }
        }
        
        int res = 0;
        for(int[] val : rectangles){
            if(val[0] < val[1]){
                if(val[0] == max) res++;
            }else{
                if(val[1] == max) res++;
            }
        }       
        
        return res;
    }
}
