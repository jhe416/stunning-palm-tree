package stunning.palm.tree.a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * priority queue and map
 * Time O(nlog(k)) Space O(n)
 */
public class TopKFrequentWords {
	public TopKFrequentWords() {}

	public List<String> topKFrequent(String[] words, int k) {
		if(words == null ||  words.length == 0) return new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for(String word : words){
			map.put(word,map.getOrDefault(word,0)+1);
		}
		Deque<String> stack = new ArrayDeque<>();
		PriorityQueue<Data> q = new PriorityQueue<>((a,b) -> {
			if(a.count == b.count)
				return b.word.compareTo(a.word);
			else
				return a.count > b.count? 1 : -1;
		});

		for(Map.Entry<String,Integer> entry : map.entrySet()){
			q.offer(new Data(entry.getKey(),entry.getValue()));
			if(q.size() > k) q.poll();
		}

		while(!q.isEmpty()) stack.push(q.poll().word);

		return new ArrayList<>(stack);
	}

	class Data{
		public String word;
		public Integer count;
		public Data(String word, Integer count){
			this.word = word;
			this.count = count;
		}
	}
}
