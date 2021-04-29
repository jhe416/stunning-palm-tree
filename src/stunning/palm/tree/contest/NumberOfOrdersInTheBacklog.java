package stunning.palm.tree.contest;

import java.util.PriorityQueue;

/*
 * priority queue greedy always pick the largest to buy smallest to sell
 * Time O(nlogn)
 * Space O(n)
 */
public class NumberOfOrdersInTheBacklog {
    int mod = 1000000000+7;
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a,b)->(a[0] == b[0]? b[1]-a[1] : b[0]-a[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>((a,b)->(a[0] == b[0]? b[1]-a[1] : a[0]-b[0]));
        
        for(int[] order : orders){
            if(order[2] == 0){
                if(sell.isEmpty() || sell.peek()[0] > order[0]){
                    buy.offer(order);
                }else{
                    while(!sell.isEmpty() && sell.peek()[0] <= order[0] && order[1] > 0){
                        int[] item = sell.poll();
                        int amount = order[1];
                        
                        order[1] -= item[1];
                        item[1] -=amount;
                        if(item[1] > 0) sell.offer(item);
                    }
                    if(order[1] > 0) buy.offer(order);
                }
            }else{
                if(buy.isEmpty() || buy.peek()[0] < order[0]){
                    sell.offer(order);
                }else{
                    while(!buy.isEmpty() && buy.peek()[0] >= order[0] && order[1] > 0){
                        int[] item = buy.poll();
                        int amount = order[1];
                        
                        order[1] -=item[1];
                        item[1] -= amount;
                        if(item[1] > 0) buy.offer(item);
                    }
                    
                    if(order[1]>0) sell.offer(order);
                }
            }
        }
        
        int res = 0;
        while(!buy.isEmpty()){
            res = (buy.poll()[1])%mod + res % mod;
        }
        
        while(!sell.isEmpty()){
            res = (sell.poll()[1])%mod + res % mod;
        }        
        return res%mod;
    }
}
