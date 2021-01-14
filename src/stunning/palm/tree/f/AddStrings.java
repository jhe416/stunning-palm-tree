package stunning.palm.tree.f;

/*
 * adding two strings
 */
public class AddStrings {
	
	public AddStrings() {}
	
    public String addStrings(String num1, String num2) {
        if(num1 == null && num2 == null) return null;
        if(num1 == null) return num2;
        if(num2 == null) return num1;
        
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            int sum = num1.charAt(i) - '0' + num2.charAt(j) - '0';
            int val = (sum + carry) % 10;
            carry = (sum + carry) /10;
            sb.append(val);
            i--;
            j--;
        }
        
        while(i>=0){
           int sum = num1.charAt(i) - '0';
           int val = (sum + carry) % 10;
           carry = (sum + carry) /10;
           sb.append(val);
           i--;
        }
        
        while(j>=0){
           int sum = num2.charAt(j) - '0'; 
           int val = (sum + carry) % 10;
           carry = (sum + carry) /10;
           sb.append(val); 
           j--; 
        }
        
        if(carry == 1) sb.append(carry);
        
        return sb.reverse().toString();
    }
    
    public String addStringsSolTwo(String num1, String num2) {
        if(num1 == null && num2 == null) return null;
        if(num1 == null) return num2;
        if(num2 == null) return num1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=num1.length()-1, j=num2.length()-1; i>=0 || j>=0; i--, j--){
            int sum1 = i>=0? num1.charAt(i) - '0' : 0;
            int sum2 = j>=0? num2.charAt(j) - '0' : 0;
            int sum = sum1 + sum2;
            int val = (sum + carry) % 10;
            carry = (sum + carry) / 10;
            sb.append(val);
        }
        
        if(carry == 1) sb.append(carry);
        return sb.reverse().toString();    	
    }  
}
