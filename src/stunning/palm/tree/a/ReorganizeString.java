package stunning.palm.tree.a;

import java.util.PriorityQueue;

/*
 * sort the number of chars
 * and insert the large one to sb and send large one to sb to offset.
 * in the end check if sb is valid
 * Time O(nlogn)
 * Space o(n)
 */
public class ReorganizeString {
	public ReorganizeString() {}
	
    public String reorganizeString(String s) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] == b[1]? a[0] - b[0] : b[1] - a[1]);
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(arr[i] > 0){
                q.offer(new int[]{i,arr[i]});
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int[] pair1 = q.poll();
            sb.append((char)(pair1[0]+'a'));
            pair1[1]--;
            if(!q.isEmpty()){
                int[] pair2 = q.poll();
                sb.append((char)(pair2[0]+'a'));
                pair2[1]--;
                if(pair2[1] > 0) q.offer(pair2);
            }
            if(pair1[1] > 0) q.offer(pair1);
        }
        
        char[] carr = sb.toString().toCharArray();
        for(int i=1;i<carr.length;i++){
            if(carr[i] == carr[i-1]) return "";
        }
        
        return sb.toString();
    }
}
