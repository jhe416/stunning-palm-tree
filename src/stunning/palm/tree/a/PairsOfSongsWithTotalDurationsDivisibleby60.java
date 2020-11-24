package stunning.palm.tree.a;

import java.util.HashMap;
import java.util.Map;

/*
 * basically another two sum, (a+b)%60=0 -> a%60+b%60=60
 * based on the equation above do two sum.
 * only difference is instead of storing the index we actually store the number of times
 * the value appeared in the array so when we have a comp found in map we know how many pairs can have.
 * Time O(n)
 * Space O(n)
 */
public class PairsOfSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        for(int i=0;i<time.length;i++){
            time[i] = time[i]%60;
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        int res=0;
        for(int i=0;i<time.length;i++){
            int comp = 60-time[i];
            if(map.containsKey(comp)){
                res+=map.get(comp);
            }
            map.put(time[i]==0? 60 : time[i],map.getOrDefault(time[i]==0? 60 : time[i],0)+1);
        }
        
        return res;
    }
}
