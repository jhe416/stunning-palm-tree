package stunning.palm.tree.a;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * basically the next greater element approach
 * but after every pop we add the popped element's previous span so we don't miss the element's previous span for the next pop 
 * Time O(1)
 * Space O(n)
 */
public class OnlineStockSpan {
    Deque<int[]> stack = new ArrayDeque<>();
    
    public OnlineStockSpan() {}
    
    public int next(int price) {
        int count = 0;

        while(!stack.isEmpty() && stack.peek()[1] <= price){
            count+=stack.pop()[0];
        }
        stack.push(new int[]{++count,price});
        return count;
    }
}
