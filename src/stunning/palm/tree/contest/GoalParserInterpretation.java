package stunning.palm.tree.contest;

/*
 * two pointer find substring
 * Time O(N)
 * space constant
 */
public class GoalParserInterpretation {
	public GoalParserInterpretation() {}
	
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(int j=0;j<command.length();j++){
            if(command.charAt(j) == 'G'){
                sb.append(command.charAt(j));
                i++;
            }else if(command.charAt(j) == '('){
                i=j;
            }else if(command.charAt(j) == ')'){
                String str = command.substring(i,j+1);
                if(str.equals("()")){
                    sb.append("o");
                }else{
                    sb.append("al");
                }
                i=j+1;
            }
        }
        
        return sb.toString();
    }
}
