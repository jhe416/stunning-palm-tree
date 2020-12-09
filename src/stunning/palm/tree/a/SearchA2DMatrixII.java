package stunning.palm.tree.a;

/*
 * left bottom top right approach
 * Time O(n/2)
 * Space constant
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;
        int l = m-1;
        int r = 0;
        
        while(l>=0 && r < n){
            if(matrix[l][r] == target) return true;
            if(matrix[l][r] < target) r++;
            else{
                l--;
            }
        }
        
        return false;
    }
}
