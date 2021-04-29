package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * use a outside ascii 257 for split
 */
public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
	public EncodeAndDecodeStrings() {}
	
    String key = String.valueOf((char)257);
    public String encode(List<String> strs) {
        if(strs == null || strs.isEmpty()) return null;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i));
            if(i < strs.size()-1) sb.append(key);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        return Arrays.asList(s.split(key,-1));
    } 
}
