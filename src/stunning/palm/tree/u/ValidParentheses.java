package stunning.palm.tree.u;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
	public ValidParentheses() {}
	
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c ==')'){
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }else if(c==']'){
                if(stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();                
            }else if(c=='}'){
                if(stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();                
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
