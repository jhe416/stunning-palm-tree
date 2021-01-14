package stunning.palm.tree.f;

import java.util.List;

import stunning.palm.tree.util.BinaryMatrix;

/*
 * start from bottom right move left if 1 is found and restore the col index to the res if is smaller
 * move up if 0 encountered. this is how to find the left most one
 * Time O(n)
 * Space constant
 */
public class LeftmostColumnWithAtLeastAOne {
	public LeftmostColumnWithAtLeastAOne() {}
	
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int n = list.get(1), m = list.get(0);
        int res = -1;
        int i=m-1, j=n-1;
        while(i>=0 && j>=0){
            int val = binaryMatrix.get(i,j);
            if(val == 0){
                i--;
            }else{
                res = res == -1? j : Math.min(res,j);
                j--;
            }
        }
        
        return res;
    }
}
