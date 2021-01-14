package stunning.palm.tree.f;

/*
 * left to right remove the invalid parentheses
 * right to left remove the invalid parentheses
 * Time O(n)
 * space constant
 */
public class MinimumRemoveToMakeValidParentheses {
	public MinimumRemoveToMakeValidParentheses() {}
	
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        char[] carr = s.toCharArray();
        
        for(int i=0;i<carr.length;i++){
            if(carr[i] == '(') open++;
            else if(carr[i] == ')'){
                if(open-1 < 0){
                    carr[i] = 0;
                }else{
                    open--;
                }
            }
        }
        
        open = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(carr[i] == ')') open++;
            else if(carr[i] == '('){
                if(open - 1 < 0) carr[i] = 0;
                else open--;
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        for(char c : carr){
            if(c==0)continue;
            sb.append(c);
        }
        
        return sb.toString();
    }
}
