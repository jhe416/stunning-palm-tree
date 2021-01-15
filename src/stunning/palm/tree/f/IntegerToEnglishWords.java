package stunning.palm.tree.f;

/*
 * recursion to find the string.
 * time O(n) as the given number grow the recursion division grow as well
 * space constant
 */
public class IntegerToEnglishWords {
	public IntegerToEnglishWords() {}
	
    String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] twos = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return helper(num).trim();
    }
    
    private String helper(int num){
        if(num<10) return ones[num];
        else if(num<20) return twos[num%10];
        else if(num<100) return tens[num/10] + " " + helper(num%10);
        else if(num<1000) return ones[num/100]+ " Hundred " + helper(num%100).trim();
        else if(num<1000000) return helper(num/1000).trim() + " Thousand " + helper(num%1000).trim();
        else if(num<1000000000) return helper(num/1000000).trim() + " Million " + helper(num%1000000).trim();
        else return helper(num/1000000000).trim() + " Billion " + helper(num%1000000000).trim();
    }
}
