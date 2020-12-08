package stunning.palm.tree.a;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * stack push in any right direction asteroid
 * when left direction asteroid encountered. 
 * pop any rights smaller than abs left
 * only add left to the stack if no right is greater than left. or stack is Empty(either for first add or all right exploded)
 * especial case handle when a right and left same size pop right and not adding left
 * Time O(n)
 * Space O(N)
 */
public class AsteroidCollision {

	public AsteroidCollision() {}
	
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> right = new ArrayDeque<>();
        
        outer:
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i] > 0) right.push(asteroids[i]);
            else{
                while(!right.isEmpty() && right.peek()>0 && right.peek() <= -asteroids[i]){
                    if(right.peek() == -asteroids[i]){
                        right.pop();
                        continue outer;
                    }
                    right.pop();
                }
                if(right.isEmpty() || right.peek() < 0){
                    right.push(asteroids[i]);
                }
            }
        }
        
        int[] res = new int[right.size()];
        for(int i=res.length-1;i>=0;i--)res[i] = right.pop();
        return res;
    }
}
