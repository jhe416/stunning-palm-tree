package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * build a email bidirectional graph and then traverse the graph dfs finding all the connected ones and merge them into
 * one and mark then visited.
 * Time O(n)
 * Space O(n)
 */
public class AccountsMergeSolTwo {
	public AccountsMergeSolTwo() {}
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Set<String>> map = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        //init graph
        for(int i=0;i<accounts.size();i++){
            String name = accounts.get(i).get(0);
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                emailToName.put(email,name);
                map.put(email, new HashSet<>());
            }
        }
        //build graph
        for(int i=0;i<accounts.size();i++){
            for(int j=2;j<accounts.get(i).size();j++){
                  map.get(accounts.get(i).get(j-1)).add(accounts.get(i).get(j));
                  map.get(accounts.get(i).get(j)).add(accounts.get(i).get(j-1));
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for(String email : emailToName.keySet()){
            if(visited.contains(email)) continue;
            List<String> list = new ArrayList<>();
            dfs(map,list,visited,email);
            Collections.sort(list);
            list.add(0,emailToName.get(email));
            res.add(list);
        }
        
        return res;
    }
    
    private void dfs(Map<String, Set<String>> map, List<String> list, Set<String> visited, String email){
        if(visited.add(email)){
            list.add(email);
            for(String otherEmail : map.get(email)){
                dfs(map,list,visited,otherEmail);
            }
        }
    }
}
