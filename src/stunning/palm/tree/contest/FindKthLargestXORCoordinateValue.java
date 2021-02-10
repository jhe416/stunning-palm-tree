package stunning.palm.tree.contest;

import java.util.PriorityQueue;

/*
 * dp, use the area xor calculated above + count, which is xor result in the row
 * Time O(nlog(n)), where n is the total of matrix n*m for worst case k can be n*m which is the
 * total number of indexes.
 * Space O(n)
 */
public class FindKthLargestXORCoordinateValue {
	public FindKthLargestXORCoordinateValue() {}
	
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix[0].length;
        int m = matrix.length;
        int[][] dp = new int[m][n];
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> (a-b));
        
        for(int i=0;i<m;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                count = j==0? matrix[i][j] : count^matrix[i][j];
                if(i==0){
                    dp[i][j] = j == 0? matrix[i][j] : matrix[i][j] ^ dp[i][j-1];
                }else{
                    dp[i][j] = dp[i-1][j] ^ count;
                }

                q.offer(dp[i][j]);
                if(q.size()>k) q.poll();
            }
        }
        
        return q.peek();
    }
}
