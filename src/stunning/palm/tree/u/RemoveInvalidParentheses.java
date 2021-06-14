package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * bfs start removing each parentheses BFS style until the first valid is found
 * then lock the size. and moving forward in bfs only valid string with the same size can be added to the result
 * using bfs garrentes the min removes to achieve the valid string
 * Time O(2^n) 2𝑛 considered to be all the possible combinations of 𝑛 items. where n is the s length
 */
public class RemoveInvalidParentheses {
	public RemoveInvalidParentheses() {}
	
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(valid(s)){
            res.add(s);
            return res;
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        Integer size = 0;
        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                String str = q.poll();
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i) == '(' || str.charAt(i) == ')'){
                        String newStr = str.substring(0,i)+str.substring(i+1,str.length());
                        if(newStr.length() >= size && visited.add(newStr)){
                            if(valid(newStr)){
                                res.add(newStr);
                                size = newStr.length();
                            }else{
                                q.offer(newStr);
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean valid(String str){
        int open =0;
        for(char c : str.toCharArray()){
            if(c=='(')open++;
            if(c==')')open--;
            if(open<0) return false;
        }
        
        return open == 0;
    }
}
