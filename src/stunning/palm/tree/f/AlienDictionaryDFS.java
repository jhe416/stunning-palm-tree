package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * build the graph bottom to top, the reverse append on sb that is the order, the key to remember is that 
 * when a char has no indication of the lex order it can be placed any where
 * Time O(n)
 * Space O(N)
 */
public class AlienDictionaryDFS {
	public AlienDictionaryDFS() {}
	
    //when a char has no indication of the lex order it can be placed any where
    public String alienOrder(String[] words) {
        Map<Character,List<Character>> graph = new HashMap<>();
        for(String word : words)
            for(char c : word.toCharArray()) 
                graph.putIfAbsent(c,new ArrayList<>());
        
        
        for(int i=1;i<words.length;i++){
            int j;
            String word1 = words[i-1], word2 = words[i];
            for(j=0;j<Math.min(word1.length(),word2.length());j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    graph.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
            if(j < word1.length() && j == word2.length()) return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int[] visited = new int[26];
        
        for(char c : graph.keySet()){
            if(visited[c-'a'] == 2) continue;
            if(!dfs(visited,graph,c,sb)) return "";
        }
        
        return sb.toString();
    }
    
    private boolean dfs(int[] visited, Map<Character,List<Character>> graph, char c, StringBuilder sb){
        if(visited[c-'a'] == 2) return true;
        if(visited[c-'a'] == 1) return false;
        visited[c-'a'] = 1;
        for(char val : graph.get(c)){
            if(!dfs(visited,graph,val,sb)) return false; 
        }
        
        sb.append(c);
        visited[c-'a'] = 2;
        return true;
    }
}
