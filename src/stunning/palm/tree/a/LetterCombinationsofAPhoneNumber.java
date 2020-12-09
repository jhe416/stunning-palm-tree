package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * recursion to find out each substring of digits combination. 
 * once the substring digits' combination found we store the result into the cache 
 * next when we seek for the same substring cache can just return the result
 * this question is very much the same to word break ii
 * Time O(4^n) worst is having 4 letters. n being the number of digits in the number
 * Space O(4^n) n is the number of the digits
 * 
 */
public class LetterCombinationsofAPhoneNumber {
	public LetterCombinationsofAPhoneNumber() {}
	
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        Map<String,List<String>> cache = new HashMap<>();
        cache.put("", new ArrayList<>());
        
        Map<Character,String> map = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        
        return dfs(map,cache,digits,0);
    }
    
    private List<String> dfs(Map<Character,String> map, Map<String,List<String>> cache, String digits, int index){
        String key = digits.substring(index,digits.length());
        if(cache.containsKey(key)) return cache.get(key);
        
        List<String> list = new ArrayList<>();
        for(Character c : map.get(digits.charAt(index)).toCharArray()){
            List<String> returnRes = dfs(map,cache,digits,index+1);
            if(returnRes.isEmpty()){
                list.add(String.valueOf(c));
            }else{
                for(String str : returnRes){
                    list.add(c + str);
                }  
            }
        }
        
        cache.put(key,list);
        return list;
    }
}
