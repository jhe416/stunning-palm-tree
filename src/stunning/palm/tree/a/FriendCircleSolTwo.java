package stunning.palm.tree.a;

/*
 * a much faster way to dfs
 * we look for the person that exits by index
 * then we dfs on that person using the total number of friend
 * each time we see the relationship we mark them 0;
 * so we dont repeat the dfs. also meaning one friends cirle will be marked as 0
 * Time O(n) Space O(n)
 */
public class FriendCircleSolTwo {
	public FriendCircleSolTwo() {}
	
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;
        int n = M.length;//number of friends
        
        int res = 0;
        for(int i=0;i<n;i++){
            if(M[i][i] == 0) continue;
            res++;
            dfs(M,i,n);
        }
        return res;
    }
    
    private void dfs(int[][] M, int i, int n){
        if(M[i][i] == 0) return;
        M[i][i] = 0;
        
        for(int k=0;k<n;k++){
            if(M[i][k] == 1){
                M[i][k] = 0;
                dfs(M,k,n);  
            }
        }
    }
}
