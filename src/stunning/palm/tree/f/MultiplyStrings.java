package stunning.palm.tree.f;

public class MultiplyStrings {
	public MultiplyStrings() {}
	
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] res = new int[num1.length() + num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            char c1 = num1.charAt(i);
            for(int j=num2.length()-1, offset = num1.length() - i -1; j>=0; j--, offset++){
                char c2 = num2.charAt(j);
                int index = res.length - offset-1;
                int p = (c1-'0') * (c2-'0') + res[index];
                res[index] = p % 10;
                res[index-1] += p/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int val : res){
            if(val == 0 && sb.length() == 0) continue;
            sb.append(val);
        }
        return sb.toString();
    }
}
