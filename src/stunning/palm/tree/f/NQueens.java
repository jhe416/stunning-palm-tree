package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * each row try to fit different Qs until last Q is filled
 * need to figure out how to postion two diagonal arr when given i and j
 * i+j = diagonal 1 index
 * n -1 - (j - i) = diagonal 2 index;
 * Time O(n^2)
 * Space O(n)
 * n being the given n*n
 */
public class NQueens {
	public NQueens() {}
	
    List<List<String>> res  = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i],'.');

        int[] cols = new int[n];
        int[] diag1 = new int[2*n-1];
        int[] diag2 = new int[2*n-1];//length/2 - (j-i)
        
        helper(n,0,cols,diag1,diag2,board,0);
        return res;
    }
    
    private void helper(int n, int queen, int[] cols, int[] diag1, int[] diag2,char[][] board, int i){
        if(queen == n){
            List<String> list = new ArrayList<>();
            for(int k=0;k<n;k++) list.add(new String(board[k]));
            res.add(list);
            return;
        }
        
        for(int j=0;j<n;j++){
            if(cols[j] != 0 || diag1[i+j] != 0 || diag2[n-1-(j-i)] != 0) continue;
            cols[j] = 1; diag1[i+j] =1; diag2[n-1-(j-i)] = 1;
            board[i][j]='Q';
            helper(n,queen+1,cols,diag1,diag2,board,i+1);
            cols[j] = 0; diag1[i+j] =0; diag2[n-1-(j-i)] = 0;
            board[i][j]='.';
        }
    }
}
