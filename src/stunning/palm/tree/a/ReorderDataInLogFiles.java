package stunning.palm.tree.a;

import java.util.Arrays;

/*
 * this question is a test for the knowledge of sort and compareTo method
 */
public class ReorderDataInLogFiles {
	public ReorderDataInLogFiles() {}
	
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a,b)->{
            String[] split1 = a.split(" ", 2);
            String[] split2 = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int val = split1[1].compareTo(split2[1]);
                if(val != 0) return val;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1? (isDigit2? 0 : 1) : -1;
        });
           
        return logs;
    }
}
