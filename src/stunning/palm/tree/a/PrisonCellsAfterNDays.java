package stunning.palm.tree.a;

import java.util.HashMap;
import java.util.Map;

/*
 * this question is finding pattern..the number repeats itself every next 14 index
 * run the program below to see the pattern.
 * Time constant..
 * space constant
 */
public class PrisonCellsAfterNDays {
	public PrisonCellsAfterNDays() {}
	
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int j=1;j<15;j++){
            int[] nums = new int[cells.length];
            for(int i=0;i<cells.length;i++){
                if(i-1<0 || i+1 == cells.length){
                    nums[i]=0;
                }else{
                    if(cells[i-1] == cells[i+1]){
                        nums[i]=1;
                    }else{
                        nums[i]=0;
                    }
                }
            }
            cells=nums;
            map.put(j,nums);
        }
        
        return map.get(N%14==0? 14 : N%14);
    }
    
    private void findPattern() {
    	int[] arr = {0, 1, 0, 1, 1, 0, 0, 1};
    	System.out.println("0: 01011001");
    	StringBuilder sb = new StringBuilder();
    	for(int j=1;j<100;j++) {
    		int[] newArr = new int[8];
    		sb.append(j);sb.append(": ");
    		for(int i=0;i<8;i++) {
    			if(i-1<0 || i+1 ==8) {
    				sb.append(0);
    				newArr[i] = 0;
    			}else {
    				if(arr[i-1] == arr[i+1]) {
    					newArr[i] = 1;
    					sb.append(1);
    				}else {
    					sb.append(0);
    					newArr[i] = 0;
    				}
    			}
    		}
    		System.out.println(sb.toString());
    		sb.setLength(0);
    		arr = newArr;
    	}
    }
}