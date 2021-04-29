package stunning.palm.tree.contest;

public class TruncateSentence {
	public TruncateSentence() {}
	
    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append(arr[i]);
            if(i!= k-1)sb.append(" ");
        }
        
        return sb.toString();
    }
}
