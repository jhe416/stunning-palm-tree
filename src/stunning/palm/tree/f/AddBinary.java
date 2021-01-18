package stunning.palm.tree.f;

/*
 * T: O(n)
 * S: Constant
 */
public class AddBinary {
	public AddBinary() {}
	
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i=0, j=0;
        for(i=a.length()-1,j=b.length()-1; i>=0 || j>=0; i--,j--){
            int val1 = i>=0? a.charAt(i) - '0' : 0;
            int val2 = j>=0? b.charAt(j) - '0' : 0;
            int sum = (carry + val1 + val2) % 2;
            carry = (carry + val1 + val2)/2;
            sb.append(sum);
        }
        if(carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
