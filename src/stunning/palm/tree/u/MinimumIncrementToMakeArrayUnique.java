package stunning.palm.tree.u;

import java.util.Arrays;

/*
 * greedy approach...
 * first sort, then the current A[i] must be greater or equal to the previous max + 1 to achieve no operations
 * if current A[i] is smaller than pre max + 1 then repmax+1 - A[i] operations needed to make A[i] unqiue in the sequence of 1...i
 * we refresh the pre max between the maximum on A[i], premax + 1;
 * Time O(nlog(n))
 * Space constant
 */
public class MinimumIncrementToMakeArrayUnique {
	public MinimumIncrementToMakeArrayUnique() {}
	
    public int minIncrementForUnique(int[] A) {
        if(A.length == 0) return 0;
        Arrays.sort(A);
        int pre = A[0], res = 0;
        for(int i=1;i<A.length;i++){
            int exp = pre+1;
            //node when A[i] is smaller than exp, this means to form uniqueness on previous numbers, operations are added 1, 2, 3.. to the numbers to a point surpasses the A[i]
            //and A[i] has already been generated. so A[i] has to be change to premax + 1;
            res += A[i] >= exp? 0 : exp-A[i];
            pre = Math.max(A[i] , exp);
        }
        
        return res;
    }
}
