package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * a trie alg, using map store a dict name as key and dict content as value
 * a dict can have a list of content, a name and list list of dicts(a map)
 * O(logn)
 * Space o(N)
 */
public class DesignInMemoryFileSystem {
    Dict root = new Dict("");
    
    public DesignInMemoryFileSystem() {}
    
    public List<String> ls(String path) {
        String[] arr = path.split("/");
        return lsHelper(arr,root,1);
    }

    private List<String> lsHelper(String[] arr, Dict curr, int i){
        if(i==arr.length || arr.length == 0){
            if(!curr.content.isEmpty()) return Arrays.asList(curr.name);
            List<String> res = new ArrayList<>(curr.map.keySet());
            Collections.sort(res);
            return res;
        }
        Dict tmp = curr.map.getOrDefault(arr[i], new Dict(arr[i]));
        curr.map.putIfAbsent(arr[i],tmp);
        return lsHelper(arr,tmp,i+1);
    }
    
    private List<String> helper(String[] arr, Dict curr, int i){
        if(i==arr.length || arr.length == 0) return curr.content;
        Dict tmp = curr.map.getOrDefault(arr[i], new Dict(arr[i]));
        curr.map.putIfAbsent(arr[i],tmp);
        return helper(arr,tmp,i+1);
    }
    
    public void mkdir(String path) {
        helper(path.split("/"),root,1);
    }
    
    public void addContentToFile(String filePath, String content) {
        List<String> list = helper(filePath.split("/"),root,1);
        list.add(content);
    }
    
    public String readContentFromFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        List<String> content = helper(filePath.split("/"),root,1);

        for(String val : content){
            sb.append(val);
        }
        
        return sb.toString().trim();
    }
    
    class Dict{
        List<String> content = new ArrayList<>();
        Map<String,Dict> map = new HashMap<>();
        String name;
        
        public Dict(String name){
            this.name =  name;
        }
    }
}
