package stunning.palm.tree.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {
	public static void main(String[] args) {
		FileSystem sol = new FileSystem();
		sol.addDirectory("/a/b/c/d/");
		sol.addDirectory("/Users/jhe/Desktop");
		sol.addFile("/Users/jhe/Desktop/idontknowthenameofthisfile");
		sol.addFile("/a/b/c/d");
		sol.addFile("/a/b/c/jay");
		sol.addFile("/jayjay");
		sol.printSystem();
	}
	
	public FileSystem() {}
	Directory root = new Directory();
	public void addDirectory(String path) {
		String[] arr = path.split("/");
		Directory tmp = root;
		for(String dict : arr) {
			if(dict.isEmpty()) continue;
			tmp = tmp.add(dict);
		}
	}
	
	
	public void addFile(String path) {
		String[] arr = path.split("/");
		Directory tmp = root;
		int i;
		for(i=0;i<arr.length-1;i++) {
			if(arr[i].isBlank()) continue;
			tmp = tmp.get(arr[i]);
		}
		tmp.addFile(arr[i]);
	}
	
	public void printSystem() {
		dfs(root,"/");
	}
	
	private void dfs(Directory root, String path) {
		for(var entry : root.map.entrySet()) {
			dfs(entry.getValue(),path+entry.getKey()+"/");
		}
		System.out.println(path);
		for(String name : root.files) {
			System.out.print(name + System.lineSeparator());
		}
	}
}

class Directory{
	List<String> files = new ArrayList<>();
	Map<String,Directory> map = new HashMap<>();
	
	public Directory() {}
	
	public Directory add(String dict) {
		map.computeIfAbsent(dict, i -> new Directory());
		return map.get(dict);
	}
	
	public Directory get(String dict) {
		return map.get(dict);
	}
	
	public void addFile(String name) {
		files.add(name);
	}
}
