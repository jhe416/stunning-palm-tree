package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.List;

/*
 * findout invalid open and close brackets and use recursion(dfs) to finding out all combinations of removed invalids
 * key to skip repeat characters as well as starting at the correct index to avoid repeats
 * time complexity: we have an option to remove or not remove on every postion of the give string, 
 * so the total substring in this case is 2^n;
 * for every substring we will need to loop over to making sure is valid
 * so Time Complexity O(n*2^n)
 * Space O(n): defination is below:
 * Space Complexity : O(N) because we are resorting to a recursive solution 
 * and for a recursive solution there is always stack space used as internal 
 * function states are saved onto a stack during recursion. 
 * The maximum depth of recursion decides the stack space used. 
 * Since we process one character at a time and the base case for 
 * the recursion is when we have processed all of the characters of the expression string, 
 * the size of the stack would be O(N). 
 * Note that we are not considering the space required to store the valid expressions. 
 * We only count the intermediate space here.
 * 
 * In summary: when recursion reach the end, in the worst case, all characters are been processed in the end
 * so we will need O(n) of recursion space stack.
 * Time O(n) 
 */
public class RemoveInvalidParentheses {
    private List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {        
        int left = 0, right = 0;
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == '(') left++;
            else if(c == ')') left--;
            if(left<0){
                right++;
                left=0;
            }
        }
        
        helper(s, left, right, 0);
        return res;
    }
    
    private void helper(String s, int open ,int close, int index){
        if(open == close && close == 0){
            if(isValid(s)){
                res.add(s);
            }
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(i>0 && s.charAt(i) == s.charAt(i-1)) continue;
            if(s.charAt(i) == '(' && open > 0){
               String str = s.substring(0,i) + s.substring(i+1,s.length()); 
               helper(str,open-1, close,i); 
            }else if(s.charAt(i) == ')' && close > 0){
               String str = s.substring(0,i) + s.substring(i+1,s.length()); 
               helper(str,open, close-1,i);                 
            }
        }
    }
    
    private boolean isValid(String s){
        int left = 0, right = 0;
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == '(') left++;
            else if(c == ')') left--;
            if(left<0){
                right++;
                left=0;
            }
        }
        return left == right && left == 0;
    } 
}
