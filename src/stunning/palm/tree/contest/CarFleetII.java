package stunning.palm.tree.contest;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 1. using stack to create a descending stack that any car has a greater or equal speed than the current one is out
 * 2. for example car: a, b, c if the time a collides with b is greater then b collides with c. then a actually collides with (b+c)
 * therefore the speed on car b cannot be counted to calculate the collide time for a. and b needs to be poped out from the stack.
 * 
 *  Note: time is happening in parallel.
 *  
 *  Time O(n)
 *  Space O(n)
 */
public class CarFleetII {
	public CarFleetII() {}
	
    public double[] getCollisionTimes(int[][] cars) {
        Deque<Integer> stack = new ArrayDeque<>();
        double[] res = new double[cars.length];
        for(int i=cars.length-1;i>=0;i--){
            double s1 = Double.valueOf(cars[i][1]), p1 = Double.valueOf(cars[i][0]);
            res[i] = -1;
            while(!stack.isEmpty()){
                int index = stack.peek();
                double s2 = Double.valueOf(cars[index][1]), p2 = Double.valueOf(cars[index][0]);
                if(s2 >= s1 || (p2-p1)/(s1-s2)>=res[index] && res[index]>0){
                    stack.pop();
                }else break;
            }
            
            if(!stack.isEmpty()){
                int index = stack.peek();
                double s2 = Double.valueOf(cars[index][1]), p2 = Double.valueOf(cars[index][0]);                
                res[i] = (p2-p1)/(s1-s2);
            }
            
            stack.push(i);
        }
        
        return res;
    }
}
