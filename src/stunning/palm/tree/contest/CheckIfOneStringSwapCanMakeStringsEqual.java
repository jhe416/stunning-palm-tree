package stunning.palm.tree.contest;

public class CheckIfOneStringSwapCanMakeStringsEqual {
	public CheckIfOneStringSwapCanMakeStringsEqual() {}
	
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int n = s1.length();
        int count = 0;
        int[] arr = new int[26];
        
        for(int i=0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        
        //string has to be equal in terms of chars 
        for(int val : arr)
            if(val != 0) return false;
        
        
        return count<3;
    }
}
