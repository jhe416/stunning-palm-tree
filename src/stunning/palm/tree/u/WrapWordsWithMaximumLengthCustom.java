package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.List;

public class WrapWordsWithMaximumLengthCustom {

	public List<String> wrapwords(String txt, int max) {
		String[] words = txt.split(" ");
		StringBuilder sb = new StringBuilder();
		List<String> res = new ArrayList<>();
		for(String word : words) {
			if(sb.length() == 0) {
				sb.append(word);
			}else if(sb.length() + word.length() + 1 <=max) {
				sb.append(" ").append(word);
			}else {
				res.add(sb.toString());
				sb = new StringBuilder(word);
			}
		}
		
		res.add(sb.toString());
		
		return res;
	}
	//(m/n)
	public List<String> orderWithMandN(String txt, int max){
		List<String> list = wrapwords(txt,max-6);
		int n = list.size();
		List<String> res = new ArrayList<>();
		int m=1;
		for(String str : list) {
			res.add(str+String.format(" (%d/%d)", m++,n));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		WrapWordsWithMaximumLengthCustom sol = new WrapWordsWithMaximumLengthCustom();
		
		var res = sol.orderWithMandN("hello world I like you", 17);
		for(var str : res) System.out.println(str);	
	}
}
