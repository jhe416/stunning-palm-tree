package stunning.palm.tree.contest;
//Splitting a String Into Descending Consecutive Values
class SplittingAStringIntoDescendingConsecutiveValues {
	
	public SplittingAStringIntoDescendingConsecutiveValues() {}
	
    public boolean splitString(String s) {
        return helper("",s,0);
    }
 
    private boolean helper(String p, String s, int index){
        if(!p.isEmpty() && compare(p,s)) return true;
        
        for(int i=index;i<s.length();i++){
            String sub = s.substring(index,i+1);
            if(sub.isEmpty() || previousZero(sub)) continue;
            if(p.isEmpty() || compare(p,sub)){
                if(helper(sub,s.substring(i+1,s.length()),0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean previousZero(String p){
        for(char c : p.toCharArray()){
            if(c > '0') return false;
        } 
        return true;
    }
    
    private boolean compare(String str1, String str2){
        if(str1.isEmpty() || str2.isEmpty()) return false;
    	StringBuilder sb1 = new StringBuilder();
    	for(char c : str1.toCharArray()) {
    		if(c =='0' && sb1.length() == 0) continue;
    		sb1.append(c);
    	}
    	if(sb1.length() == 0) sb1.append("0");
    	StringBuilder sb2 = new StringBuilder();
    	for(char c : str2.toCharArray()) {
    		if(c == '0' && sb2.length() == 0) continue;
    		sb2.append(c);
    	}
    	if(sb2.length() == 0) sb2.append("0");
        return sb1.toString().equals(addOne(sb2.toString()));
    }
    
    private String addOne(String str1) {
    	char[] arr = str1.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	int val = (1 + (arr[str1.length()-1] -'0')) % 10;
    	int carry = (1 + (arr[str1.length()-1] -'0')) / 10;
    	sb.insert(0,val);
    	for(int i=arr.length-2;i>=0;i--) {
    		val = ((arr[i] -'0') + carry) % 10;
    		carry = ((arr[i] -'0') + carry) / 10;
    		sb.insert(0,val);
    	}
    	if(carry > 0)sb.insert(0,carry);
    	return sb.toString();
    }
}