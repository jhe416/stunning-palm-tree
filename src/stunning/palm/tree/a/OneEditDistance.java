package stunning.palm.tree.a;

public class OneEditDistance {
	public OneEditDistance() {}
	
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false;
        if(Math.abs(s.length() - t.length()) > 1) return false;
        
        int i=0,j=0,diff=0;
        while(i<s.length() && j<t.length()){
            char c1 = s.charAt(i);
            char c2 = t.charAt(j);
            
            if(c1 == c2){
                i++;j++;
            }else{
                if(++diff > 1) return false;
                if(s.length() == t.length()){
                    i++;j++;
                }else if(s.length() > t.length()){
                    i++;
                }else{
                    j++;
                }
            }
        }
        
        return true;
    }
}
