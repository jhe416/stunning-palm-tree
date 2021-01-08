package stunning.palm.tree.contest;

/*
 * some special cases to handle..实现题
 */
public class ReformatPhoneNumber {
	public ReformatPhoneNumber() {}
	
    public String reformatNumber(String number) {
        number = number.replaceAll("-","");
        number = number.replaceAll(" ","");
        char[] arr = number.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i=0;
        for(i=0;i<number.length() && number.length() > 4;i++){            
            if(i > 0 && i%3 == 0){
                sb.append("-");
                if(number.length() - i<5)break;
            }
            sb.append(arr[i]);
        }
        
        if(number.length() - i == 4){
            sb.append(number.substring(i,i+2));
            sb.append("-");
            sb.append(number.substring(i+2,number.length()));
        }else{
            sb.append(number.substring(i,number.length()));
        }
        
        return sb.toString();
    }
}
