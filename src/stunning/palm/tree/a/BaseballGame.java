package stunning.palm.tree.a;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * stack o(n) o(n) solution :)
 */
public class BaseballGame {
	public BaseballGame() {}
	
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(String str : ops){
            if(Character.isDigit(str.charAt(0)) || str.charAt(0) == '-'){
                stack.push(Integer.valueOf(str));
            }else if("C".equals(str)){
                stack.pop();
            }else if("D".equals(str)){
                stack.push(stack.peek()*2);
            }else if("+".equals(str)){
                int tmp = stack.pop();
                int sum = tmp + stack.peek();
                stack.push(tmp);
                stack.push(sum);
            }
        }
        
        int res = 0;
        while(!stack.isEmpty()) res+=stack.pop();
        return res;
    }
}
