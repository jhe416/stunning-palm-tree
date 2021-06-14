package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public GenerateParentheses() {}
	
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n,"");
        return res;
    }
    
    private void dfs(int open, int close, int n, String str){
        if(open == close && open == n){
            res.add(str);
            return;
        }
        if(open > n || close > n || open < close) return;
        dfs(open+1,close,n,str+"(");
        dfs(open,close+1,n,str+")");
    }
}
