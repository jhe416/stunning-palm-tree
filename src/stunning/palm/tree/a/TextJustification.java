package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * first find each max width window that can store the max words;
 * then we pad;
 * I use a map to store the actual size of each string and I split each word with a key char (257);
 * during pad, calculate the even spaces need to add, and then add the extra space using mod, one at a time
 * so left is evenly distruabted to the right
 * special case need to handle here that if only one word.
 * in this case spots to land spaces is zero so we add the word to stringbuilder and fill the max window with spaces
 * Time O(n) n as the total length of words
 * Space O(n)
 * 
 */
public class TextJustification {
	
	public TextJustification() {}
	
    public List<String> fullJustify(String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int size = 0;
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        char key = (char)257;
        for(String word : words){
            if(sb.length() == 0){
                sb.append(word);
                size+=word.length();
            }else if(sb.length() + word.length() + 1 > maxWidth){
                map.put(sb.toString(),size);
                list.add(sb.toString());
                sb = new StringBuilder(word);
                size = word.length();
            }else{
                sb.append(key);
                sb.append(word);
                size+=word.length();
            }
        }
        //add the last string 
        if(sb.length() > 0){
            list.add(sb.toString());
            map.put(sb.toString(),size);
        }
        
        List<String> res = new ArrayList<>();
        //pad space
        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            size = map.get(str);
            String[] arr = str.split(String.valueOf(key));
            sb = new StringBuilder();
            int diff = maxWidth - size;
            
            if(i == list.size()-1){
                for(int j=0;j<arr.length;j++){
                    if(sb.length() == 0) sb.append(arr[j]);
                    else{
                        sb.append(" ");
                        diff--;
                        sb.append(arr[j]);
                    }
                }
                
                for(int k=0;k<diff;k++)sb.append(" ");
                res.add(sb.toString());
                continue;
            }
            
            int spots = arr.length-1;
            if(spots == 0){
                sb.append(arr[0]);
                for(int k=0;k<maxWidth-arr[0].length();k++){
                    sb.append(" ");
                }
                res.add(sb.toString());
                continue;
            }
            int spaces = diff/spots;
            int extra = diff % spots;
            
            for(int j=0;j<arr.length;j++){
                if(sb.length()==0){
                    sb.append(arr[j]);
                }else{
                    for(int k=0;k<spaces;k++) sb.append(" ");
                    if(extra-- > 0){
                        sb.append(" ");
                    }
                    sb.append(arr[j]);
                }
            }
            res.add(sb.toString());
        }
        
        return res;
    }
}
