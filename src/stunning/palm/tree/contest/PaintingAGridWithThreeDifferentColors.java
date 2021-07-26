package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * this question is hard af..just watch this vid 
 * https://www.youtube.com/watch?v=W7CVMwqzqFs&ab_channel=CodingForDummies
 */
public class PaintingAGridWithThreeDifferentColors {
	public PaintingAGridWithThreeDifferentColors() {}
	
    List<List<Integer>> graph = new ArrayList<>();
    List<String> list = new ArrayList<>();
    char[] carr = {'G','R','B'};
    int mod = 1000000000+7;
    public int colorTheGrid(int m, int n) {
        buildString(m,"",'\0');
        int[][] dp = new int[list.size()][n];
        for(int i=0;i<list.size();i++){
            graph.add(new ArrayList<>());
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<list.size();i++){
            outer: for(int j=0;j<list.size();j++){
                if(i==j) continue;
                for(int k=0;k<m;k++){
                    if(list.get(i).charAt(k) == list.get(j).charAt(k)) continue outer;
                }
                graph.get(i).add(j);
            }
        }
        
        long res = 0;
        for(int i=0;i<list.size();i++){
            res = (res%mod + dp(dp,i,n-1,graph)%mod)%mod;
        }
        
        return (int)res;
    }
    
    public int dp(int[][] dp, int i, int n, List<List<Integer>> graph){
        if(n == 0) return 1;
        if(dp[i][n] != -1) return dp[i][n];
        long res = 0;
        for(int next : graph.get(i)){
            res = (res%mod + dp(dp,next,n-1,graph)%mod)%mod;
        }
        dp[i][n] = (int)res;
        return dp[i][n];
    }
    
    public void buildString(int m, String str, char p){
        if(m == 0){
            list.add(str);
            return;
        }
        
        for(char c : carr){
            if(c == p) continue;
            buildString(m-1,str+c,c);
        }
    }
}
