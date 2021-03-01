package stunning.palm.tree.contest;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * since position is unique we sort the position and store the pos index in order to get speed
 * then we traverse from last to first using stack. only push into stack if the current car cannot catch up to car in front before target line 
 * to do this, we first find out how long will it take for the last car in the stack reach the target, then we calculate the current car
 * if the current car has greater speed and the time to catch up the next car t = (p2-p1)/(s1-s2) is smaller or equal to timeleft then we know
 * the current car can catch up to the next car so we ignore the current car until the one cannot be catched up is found
 * 
 * Note once the car is catches up the car goes bumper to bumper meaning the slowest speed is taken and the count as 1, so we only care about cars not 
 * able to catch up to the next ones before the target line.
 * Time O(nlog(n)) because of the sort
 * Space O(n)
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<position.length;i++){
            map.put(position[i],i);
        }
        
        Arrays.sort(position);
        Deque<Integer> stack = new ArrayDeque<>();

        outer:
        for(int i=position.length-1;i>=0;i--){
            double p1 = position[i], s1 = speed[map.get(position[i])];
            while(!stack.isEmpty()){
                int index = stack.peek();
                double p2 = position[index], s2 = speed[map.get(position[index])];
                double timeLeft = (target - p2)/s2;
                if(s2 < s1 && (p2-p1)/(s1-s2) <= timeLeft){
                    continue outer;
                }else break;
            }

            stack.push(i);
        }
        
        
        
        return stack.size();
    }
    
    /*
     * no stack
     * sort by position, but calculate the time reach target up front
     * now only update res if the new time reach t target is bigger than the previous 
     * Time O(nlog(n))
     * Space O(N)
     */
    public int carFleetSlowTwo(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        
        for(int i=0;i<cars.length;i++){
            cars[i] = new double[]{position[i], (target-position[i])/Double.valueOf(speed[i])};
        }
        
        Arrays.sort(cars,(a,b)->((int)(b[0] - a[0])));
        int res =0;
        double current = Double.MIN_VALUE;
        for(int i=0;i<cars.length;i++){
            if(cars[i][1] > current){
                res++;
                current = cars[i][1];
            }
        }
        
        return res;
    }
}
