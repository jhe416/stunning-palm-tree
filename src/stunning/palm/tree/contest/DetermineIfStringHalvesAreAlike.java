package stunning.palm.tree.contest;

//DetermineIfStringHalvesAreAlike
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
	public DetermineIfStringHalvesAreAlike() {}
	
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int n = s.length();
        int h = n/2;
        int count = 0;
        for(int i=0;i<h;i++){
            if(set.contains(s.charAt(i))) count++;
        }
        
        for(int i=h;i<n;i++){
            if(set.contains(s.charAt(i))) count--;
        }
        
        return count == 0;
    }
}
