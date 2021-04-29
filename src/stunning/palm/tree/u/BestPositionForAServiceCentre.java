package stunning.palm.tree.u;

/*
 * find max i and j (x or y)
 * trying x and y starting from 0 0 increment 0.001
 * the precision will match 10^-5 as 0.001 * 0.001 = 0.00001 = 10^-5
 * 
 */
public class BestPositionForAServiceCentre {
	public BestPositionForAServiceCentre() {}
	
    public double getMinDistSum(int[][] positions) {
        if(positions.length == 1) return 0.0;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        
        for(int[] pos : positions){
            maxx = Math.max(pos[0],maxx);
            maxy = Math.max(pos[1],maxy);
        }
        
        double res = Double.MAX_VALUE;
        for(double i=0;i<=maxy;i+=0.001){
            for(double j=0;j<=maxx;j+=0.001){
                double sum = 0.0;
                for(int[] pos : positions){
                    double xpow2 = (j-Double.valueOf(pos[0])) * (j-Double.valueOf(pos[0]));
                    double ypow2 = (i-Double.valueOf(pos[1])) * (i-Double.valueOf(pos[1]));
                    sum+= Math.sqrt(xpow2 + ypow2);
                }
                res = Math.min(res,sum);
            }
        }
        
        return res;
    }
}
