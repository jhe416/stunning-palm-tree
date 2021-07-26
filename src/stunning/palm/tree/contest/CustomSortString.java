package stunning.palm.tree.contest;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	public CustomSortString() {}
	
	public String customSortString(String order, String str) {
        if(order == null || order.length() == 0) return str;
        Map<Character,Integer> map = new HashMap<>();
        
        for(char c : str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            if(map.containsKey(c)){
                for(int i=0;i<map.get(c);i++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        
        for(var entry : map.entrySet()){
            for(int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        
        return sb.toString();
    }
}
