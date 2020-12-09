package stunning.palm.tree.a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import stunning.palm.tree.util.Node;

/*
 * a divide and conquer solution, cut when we encounter any characters in the set and is not in the brackets.
 * special case handle. when the whole array is in the bracket we remove the bracket and continue divide and conquer
 * Time O(nlog(n))
 * space constant or recursion stack 
 */
public class BuildBinaryExpressionTreeFromInfixExpression {
	public BuildBinaryExpressionTreeFromInfixExpression() {}
	
    Set<Character> set = new HashSet<>(Arrays.asList('+','-','*','/'));
    public Node expTree(String s) {
        return divideAndConqur(s,0,s.length()-1);
    }
    
    private Node divideAndConqur(String s, int start, int end){
        if(start==end) return new Node(s.charAt(start),null,null);
        int open = 0;
        for(int i=start;i<=end;i++){
            char c = s.charAt(i);
            if(set.contains(c) && open == 0){
                return new Node(c, divideAndConqur(s,start,i-1),divideAndConqur(s,i+1,end));
            }if(c == '('){
                open++;
            }else if(c == ')'){
                open--;
            }
        }
        
        return divideAndConqur(s,start+1,end-1);
    }
}
