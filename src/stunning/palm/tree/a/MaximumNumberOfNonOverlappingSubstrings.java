package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * using a 26 by 2 2d arr finding any existing character's starting range and ending range
 * loop through each range and expand until all character's range is covered
 * add the expanded range substring into the list, only if all characters are inside the range. 
 * sort the list from the smallest to largest length
 * 
 * add the value in the list to the result, and check if is valid:
 * 1. check if the current value that is about to add to the result is does not contain
 * any result values.
 * Time O(n) because the range 'arr' is constant so when sorting the arr we actually doing a O(26log26) complexity
 * the only O(n) is taking place is when expanding the range to cover all characters in the range. the correct complexity
 * here is actually o(26n) because the max we are going to have is 26 ranges
 * Space constant
 * 
 * 
 */
public class MaximumNumberOfNonOverlappingSubstrings {
	public MaximumNumberOfNonOverlappingSubstrings() {}
	
    public List<String> maxNumOfSubstrings(String s) {
        int[][] arr = new int[26][2];
        for(int i=0;i<26;i++){
            arr[i] = new int[]{-1,-1};
        }
        char[] carr = s.toCharArray();
        
        for(int i=0;i<carr.length;i++){
            int index = carr[i]-'a';
            arr[index][1] = i;
            arr[index][0] = arr[index][0] == -1? i : arr[index][0];
        }
        
        List<String> list = new ArrayList<>();
  
        outer1:
        for(int[] range : arr){
            if(range[0] == -1) continue;
            int min = range[0], max = range[1];
            
            for(int i=range[0];i<=range[1];i++){
                int index = carr[i] - 'a';
                min = Math.min(min, arr[index][0]);
                max = Math.max(max, arr[index][1]);
            }
            for(int i=min;i<=max;i++){
                int index = carr[i] - 'a';
                if(arr[index][0] != -1 && arr[index][0] < min || arr[index][1] > max) continue outer1;
            }
            list.add(s.substring(min,max+1));
        }
        
        Collections.sort(list, (a,b) -> a.length() - b.length());
        
        List<String> res = new ArrayList<>();
        
        outer2:
        for(String val : list){
            for(String str : res){
                if(val.contains(str)) continue outer2;
            }
            res.add(val);
        }
        
        if(res.isEmpty()) res.add(s);
        return res;
    }
}
