package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public TextJustification() {}
	
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length ==0) return res;
        
        StringBuilder sb = new StringBuilder();
        char key = (char)257;
        int size = 0;
        for(String word : words){
            if(sb.length() == 0){
                sb.append(word);
                size +=word.length();
            }else if(sb.length() + word.length() + 1 <= maxWidth){
                sb.append(key);
                sb.append(word);
                size += word.length();
            }else{
                res.add(buildString(size,sb,maxWidth, key));
                sb = new StringBuilder(word);
                size = word.length();
            }
        }
        
        if(sb.length() > 0){
            while(sb.length() < maxWidth) sb.append(" ");
            res.add(sb.toString().replace(String.valueOf(key)," "));
        }
        
        return res;
    }
    
    private String buildString(int size, StringBuilder wordsb, int maxWidth, char key){
        String[] words = wordsb.toString().split(String.valueOf(key));
        int diff = maxWidth - size; 
        int spaces = words.length-1 == 0? 0 : diff/(words.length-1);
        int left = words.length-1 == 0? 0 : diff % (words.length-1);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            sb.append(words[i]);
            if(i == words.length-1) continue;
            for(int j=0;j<spaces;j++){
                sb.append(" ");
            }
            if(left > 0){
                sb.append(" ");
                left--;
            }
        }
        
        while(sb.length() < maxWidth) sb.append(" ");
        return sb.toString();
    }
}
