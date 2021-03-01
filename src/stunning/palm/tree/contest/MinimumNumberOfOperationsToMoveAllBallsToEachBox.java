package stunning.palm.tree.contest;

/*
 * Time o(N)
 * Space O(N)
 */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
	public MinimumNumberOfOperationsToMoveAllBallsToEachBox() {}
	
    public int[] minOperations(String b) {
        char[] boxes = b.toCharArray();
        int n = boxes.length;
        int[] res = new int[n];
        for(int i=0,op=0,ct=0;i<n;i++){
            res[i] = op; //store current ops to current index meaning the amount of ops to move all previous 1s box to current index
            ct+=boxes[i]=='1'? 1 : 0;
            op+=ct; //we know the all the ops take to move all boxes to current index, so to move all 1 boxes to the next index would just be the current ops at current index + all the 1 box count found.(all the found 1 boxes takes only 1 op to move to the next index)
        }
        
        for(int i=boxes.length-1,op=0,ct=0;i>=0;i--){
            res[i] += op;
            ct+=boxes[i]=='1'? 1 : 0;
            op+=ct;
        }
        
        return res;
    }
}
