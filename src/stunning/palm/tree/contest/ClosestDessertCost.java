package stunning.palm.tree.contest;

/*
 * combination recursion finding the combination of toppings with the base cost that is closest to the target price.
 *  
 */
public class ClosestDessertCost {
	public ClosestDessertCost() {}
	
    int res = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[] count = new int[toppingCosts.length];
        for(int cost : baseCosts){
            helper(cost,toppingCosts,target,0,count);
        }
        
        return res;
    }
    
    private void helper(int cost, int[] costs, int target, int index, int[] count){
        if(Math.abs(target - cost) <= Math.abs(target - res)){
            res = Math.abs(target - cost) == Math.abs(target - res)? Math.min(res,cost) : cost;
        }
        
        for(int i=index;i<costs.length;i++){
            if(count[i] == 2) continue;
            count[i]++;
            helper(cost+costs[i],costs,target,i,count);
            count[i]--;
        }
    }
}
