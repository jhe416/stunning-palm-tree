package stunning.palm.tree.u;

import java.util.*;

public class UberForRealTrieSearch {
	public UberForRealTrieSearch() {}
	Trie root = new Trie();
	
	public void addResturant(String name) {
		add(name,root,0);
	}
	
	private String add(String name, Trie root, int index) {
		if(index == name.length()) {
			root.isEnd=true;
			return name;
		}
		
		Trie newData = root.add(name.charAt(index));
		String word = add(name,newData,index+1);
		newData.set.add(word);
		return word;
	}
	
	public List<String> getSuggestions(String prefix){
		List<String> res = searchTrie(prefix,root,0);
		Collections.sort(res);
		return res;
	}
	
	private List<String> searchTrie(String prefix, Trie root, int index){
		if(root == null) return new ArrayList<>();
		if(prefix.length() == index) {
			return new ArrayList<>(root.set);
		}
		
		Trie newData = root.get(prefix.charAt(index));
		return searchTrie(prefix, newData, index+1);
	}
	
    public static void main(String[] args) {
        //“beer house”, “burger king
    	UberForRealTrieSearch sol = new UberForRealTrieSearch();
        sol.addResturant("applea");
        sol.addResturant("appleab");
        sol.addResturant("azxczx");
        sol.addResturant("acaa");
        sol.addResturant("c aa");
        sol.addResturant("cbbda");
        sol.addResturant(" bbda");
        sol.addResturant(" c bbda");
        sol.addResturant("beer house");
        sol.addResturant("burger king");
        List<String> list = sol.getSuggestions("b");
        
        for(String name : list){
            System.out.println(name);
        }
    }
}

class Trie{
	public Trie[] arr = new Trie[27];
	public char c;
	public boolean isEnd;
	public Set<String> set = new HashSet<>();		
	
	public Trie() {}
	
	public Trie get(char c) {
		if(c == ' ') return arr[26];
		else return arr[c-'a'];
	}
	
	public Trie add(char c) {
		if(c == ' ') {
			if(arr[26] != null) return arr[26];
			return arr[26] = new Trie();
		}else {
			if(arr[c-'a'] != null) return arr[c-'a'];
			return arr[c-'a'] = new Trie();
		}
	}
}
