package stunning.palm.tree.f;

import java.util.*;
public class RemoveInvalidParenthesesBFS {
	public RemoveInvalidParenthesesBFS() {}
	
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(){{add("");}};
        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                String str = q.poll();
                
                if(isValid(str)){
                    res.add(str);
                }
                
                //remove one char at a time
                for(int i=0;i<str.length() && res.isEmpty();i++){
                    if(i>0 && str.charAt(i) == str.charAt(i-1)) continue;
                    if(str.charAt(i) == '(' || str.charAt(i) == ')'){
                        String newStr = str.substring(0,i)+str.substring(i+1,str.length());
                        if(!set.add(newStr)) continue;
                        q.offer(newStr);
                    }
                }
            }
        }
        
        if(res.isEmpty()) res.add("");
        return res;
    }
    
    private boolean isValid(String str){
        int open = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(')open++;
            else if(str.charAt(i) == ')') open--;
            if(open < 0) return false;
        }
        
        return open == 0;
    }
}
