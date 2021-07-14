package stunning.palm.tree.contest;

/*
 * two pass..swap the whole string
 * then swap words using two pointer
 * 
 * Time O(n)
 * space constant
 */
public class ReverseWordsInAStringII {
	public ReverseWordsInAStringII() {}
	
    public void reverseWords(char[] s) {
        int i=0, j =s.length-1;
        
        //swap
        swap(i,j,s);
        
        i=0;
        for(j=0;j<s.length;j++){
            if(s[j] == ' '){
                swap(i,j-1,s);
                i=j+1;
                continue;
            }else if(j == s.length-1){
                swap(i,j,s);
            }
        }
    }
    
    private void swap(int i, int j, char[] s){
        while(i<j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;j--;
        }              
    }
}
