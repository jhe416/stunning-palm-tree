package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * build an email -> users map
 * for each email find the users' email and merge them and when users' email have other users merge them as well
 * traverse down the graph until all all connections are found
 * Time O(n)
 * Space O(n)
 */
public class AccountsMerge {
	public AccountsMerge() {}
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,List<Integer>> map = new HashMap<>();
        int n = accounts.size();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                List<Integer> indexes = map.getOrDefault(email,new ArrayList<>());
                indexes.add(i);
                map.putIfAbsent(email,indexes);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            Set<String> mergedEmails = new HashSet<>();
            dfs(accounts, accounts.get(i), i, map, visited, mergedEmails);
            
            String name = accounts.get(i).get(0);
            List<String> resList = new ArrayList<>(mergedEmails);
            Collections.sort(resList);
            
            resList.add(0,name);
            res.add(resList);
        }
        
        return res;
    }
    
    private void dfs(List<List<String>> accounts, List<String> account, int user, Map<String,List<Integer>> map, boolean[] visited, Set<String> res){
        if(visited[user]) return;

        visited[user] = true;
        
        for(int i=1;i<account.size();i++){
            String userEmail = account.get(i);
            if(!res.add(userEmail)) continue;
            List<Integer> users = map.get(userEmail);
            for(int userIndex : users){
                dfs(accounts,accounts.get(userIndex),userIndex,map,visited,res);
            }
        }
    }
}
