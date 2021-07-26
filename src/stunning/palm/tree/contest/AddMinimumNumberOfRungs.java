package stunning.palm.tree.contest;

//AddMinimumNumberOfRungs
public class AddMinimumNumberOfRungs {
	public AddMinimumNumberOfRungs() {}
	
    public int addRungs(int[] rungs, int dist) {
        int res = 0, level = 0;
        int[] arr = new int[rungs.length+1];
        for(int i=1;i<arr.length;i++){
            arr[i] = rungs[i-1];
        }
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1] > dist){
                res += (arr[i]-arr[i-1]) % dist == 0? (arr[i]-arr[i-1]) / dist - 1 : (arr[i]-arr[i-1]) / dist;
            }
        }
        
        return res;
    }
}
