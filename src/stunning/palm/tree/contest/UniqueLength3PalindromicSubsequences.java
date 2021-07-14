package stunning.palm.tree.contest;

public class UniqueLength3PalindromicSubsequences {
	public UniqueLength3PalindromicSubsequences() {}
	
    public int countPalindromicSubsequence(String s) {
        int[][] map = new int[26][2];
        for(int i=0;i<26;i++){
            map[i][0] = -1; map[i][1] = -1;
        }
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a'][1] = i;
        }
        for(int i=s.length()-1;i>=0;i--){
            map[s.charAt(i)-'a'][0] = i;
        }
        
        int res = 0;
        for(var entry : map){
            if(entry[0] == -1 || entry[1] == -1 || entry[1] - entry[0] <2) continue;
            boolean[] visited = new boolean[26];
            for(int i=entry[0]+1;i<entry[1];i++){
                if(!visited[s.charAt(i)-'a']){
                    res++;
                    visited[s.charAt(i)-'a'] = true;
                }
            }
        }
        
        return res;
    }
}
