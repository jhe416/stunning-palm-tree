package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionaryBFS {
	public AlienDictionaryBFS() {}
	
    public String alienOrder(String[] words) {
        int[] bigCount = new int[26];
        Arrays.fill(bigCount,-1);
        
        Map<Character,List<Character>> graph = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
                if(bigCount[c-'a'] < 0) bigCount[c-'a'] = 0;
            } 
        }
        
        for(int i=1; i<words.length;i++){
            int j=0;
            String word1 = words[i-1], word2 = words[i];
            for(;j<Math.min(word1.length(),word2.length());j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    bigCount[word2.charAt(j)-'a']++;
                    break;
                }
            }
            
            if(j<word1.length() && j == word2.length()) return "";
        }
        
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<bigCount.length;i++){
            if(bigCount[i] != 0) continue;
            char c = (char)(i+'a');
            q.offer(c);
            sb.append(c);
        }
        
        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                for(char c : graph.get(q.poll())){
                    if(--bigCount[c-'a'] == 0){
                        q.offer(c);
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
