package stunning.palm.tree.f;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {
	public LongestAbsoluteFilePath() {}
	
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        
        String[] arr = input.split("\n");
        int res = 0;
        int cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(String str : arr){
            int level = str.lastIndexOf("\t") + 1;
            
            //this is the most important of the ticket
            //when stack is far down the level and current str is at top
            //we pop stack until stack reach one level above the current str level
            //the reason why stack.size > level is beacuse stack level increments from 1 to n
            //while the current level increments from 0 ... n
            while(stack.size() > level) cur -= stack.pop();
            
            int size = str.length() - level + 1; // string length minus spaces "\t" + "\"
            
            if(str.contains(".")){
                res = Math.max(cur+size-1,res);
                continue;
            }
            
            cur+=size;
            stack.push(size);
        }
        return res;
    }
}
