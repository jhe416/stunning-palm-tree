package stunning.palm.tree.a;

/*
 * This is the solution to the first follow up question to FindMedianFromDataStream
 * finding everything else is easy.
 * only thing is finding the median. once you know the total count you know where the mid located
 * then loop the counts one more time find the mid(totalcount/2) and depending on the totalcount is even or odd
 * return either mid+1 or mid+(mid+1)/2;
 * Time is constant
 * space is constant too because the max array length is 256
 */
public class StatisticsFromALargeSample {
	public StatisticsFromALargeSample() {}
	
	public double[] sampleStats(int[] count) {
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE, mean = 0, median = 0, mode=Integer.MIN_VALUE, modeVal=0, sum = 0;
        int totalCount=0, k=0;
    
        for(int i=0; i<count.length; i++){
            if(count[i] > 0){
                min = Math.min(min,i);
                max = Math.max(max,i);
                totalCount+=count[i];
                sum+=i*count[i];
                
                if(count[i] > mode){
                    modeVal = i;
                    mode = count[i];
                }
            }
        }
        
        mean = sum/(double)totalCount;
        int mid = totalCount/2;
        double median1 = 0, median2 = 0;
        for(int i=0;i<count.length;i++){
            if(mid - count[i] <= 0)
            {
                if(mid+1 - count[i] <= 0){
                    median2 = i;
                }else{
                    int j=i+1;
                    while(count[j] == 0) j++;
                    median2 = j;
                }
                if(totalCount %2 == 0){
                    median1 = i;
                }
                break;
            }
            mid-=count[i];
        }
        
        median = totalCount%2 == 0? (median1 + median2)/2.0 : median2;
        double[] res = new double[]{min,max,mean,median,modeVal};
        return res;
    }
}
