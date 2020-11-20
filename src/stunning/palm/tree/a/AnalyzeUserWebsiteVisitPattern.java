package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/*
 * store user's visited websites into a map that is sorted by treemap
 * then find all 3 combo and return the highest frequency
 * 
 */
public class AnalyzeUserWebsiteVisitPattern {
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		int n = timestamp.length;
		Map<String,TreeMap<Integer,String>> map = new HashMap<>();

		for(int i=0;i<n;i++){
			TreeMap<Integer,String> treeMap = map.getOrDefault(username[i], new TreeMap<>());
			treeMap.put(timestamp[i],website[i]);
			map.putIfAbsent(username[i],treeMap);
		}

		Map<String,Integer> visit = new HashMap<>();

		for(Map.Entry<String,TreeMap<Integer,String>> entry : map.entrySet()){
			dfs(new ArrayList<>(entry.getValue().values()), visit, 0, 0, "", new HashSet<>());
		}

		PriorityQueue<Data> q = new PriorityQueue<>((a,b) -> (a.count == b.count? a.word.compareTo(b.word) : b.count - a.count));

		for(Map.Entry<String,Integer> entry : visit.entrySet()){
			q.offer(new Data(entry.getKey(),entry.getValue()));
		}
		String[] resStr = q.poll().word.split(" ");
		return Arrays.asList(resStr);
	}

	class Data{
		String word;
		int count;

		public Data(String word, int count){
			this.word = word;
			this.count = count;
		}
	}
	private void dfs(List<String> sites, Map<String,Integer> visit, int count, int index, String key, Set<String> set){
		if(sites.size() < 3) return;
		if(count == 3){
			String trimedKey = key.trim();
			if(set.add(trimedKey))visit.put(trimedKey, visit.getOrDefault(trimedKey,0)+1);
			return;
		}

		for(int i=index;i<sites.size();i++){
			dfs(sites,visit,count+1,i+1,key+" "+sites.get(i),set);
		}
	}
}
