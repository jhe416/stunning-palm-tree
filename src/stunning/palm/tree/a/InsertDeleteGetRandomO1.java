package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * use map and list to keep record of each insert and remove
 * map has the val and the index
 * when remove swap the last val in the list with the remove val's index
 * remove the last val from the list 
 * update the last val's index in the map to the val's index;
 * and remove map's val key
 * remove O(1)
 * add O(1)
 */
public class InsertDeleteGetRandomO1 {
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int oriIndex = map.get(val);
        int tmp = list.get(list.size()-1);
        list.set(oriIndex,tmp);
        
        list.remove(list.size()-1);
        map.put(tmp,oriIndex);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
