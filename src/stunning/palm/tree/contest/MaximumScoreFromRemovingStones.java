package stunning.palm.tree.contest;

import java.util.Arrays;

/*
 * basically handling this case you be good
 * 4,4,6 
 * constant complexity 
 */
public class MaximumScoreFromRemovingStones {
	public MaximumScoreFromRemovingStones() {}
	
    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;
        Arrays.sort(arr);
        
        if(arr[0] == arr[1]){
            int count =0;
            while(arr[1]-- * 2 > arr[2]) count++;
            return count + (arr[1]+1)*2;
        }else if(arr[1] == arr[2]){
            int sum1 = arr[1];
            int val1 = arr[1] - arr[0];
            arr[1] -=val1;
            arr[2] -=val1;
            int count =0;
            while(arr[1]-- * 2 > arr[2]) count++;
            int sum2 = count + (arr[1]+1)*2+val1;
            return Math.max(sum1,sum2);            
        }else{
            int sum1 = Math.min(arr[0]+arr[1],arr[2]);
            int val1 = arr[1] - arr[0];
            arr[1] -=val1;
            arr[2] -=val1;
            int count =0;
            while(arr[1]-- * 2 > arr[2]) count++;
            int sum2 = count + (arr[1]+1)*2+val1;
            return Math.max(sum1,sum2);
        }
    }
}
