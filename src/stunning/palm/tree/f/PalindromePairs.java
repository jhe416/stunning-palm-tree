package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * to pair a palindrome if sub1 is palindrome, the we can find the reverse of sub2 to make a palindrome pair
 * Time O(n) n is the total words length;
 * space O(m) m is total number of words 
 */
public class PalindromePairs {
	public PalindromePairs() {}
	
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }
        
        for(int i=0;i<words.length;i++){
            String word = words[i];
            for(int j=0;j<word.length();j++){                
                String sub1 = word.substring(0,j);
                String sub2 = word.substring(j);
                
                if(valid(sub1)){
                    StringBuilder sb = new StringBuilder(sub2).reverse();
                    int index = map.getOrDefault(sb.toString(),i);
                    if(index != i) res.add(Arrays.asList(index,i));
                }
                
                if(valid(sub2)){
                    StringBuilder sb = new StringBuilder(sub1).reverse();
                    int index = map.getOrDefault(sb.toString(),i);
                    if(index != i){
                        res.add(Arrays.asList(i,index)); 
                        //if is empty string it can be added in both side. 
                        if(sb.length() == 0){
                            res.add(Arrays.asList(index,i));
                        }
                    } 
                }
            }
        }
        
        return res;
    }
    
    private boolean valid(String word){
        char[] arr = word.toCharArray();
        int l=0,r=arr.length-1;
        while(l<r){
            if(arr[l++] != arr[r--]) return false;
        }
        
        return true;
    }
}
