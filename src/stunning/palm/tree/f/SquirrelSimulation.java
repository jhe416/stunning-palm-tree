package stunning.palm.tree.f;

/*
 * calculated distance from tree to all nuts and bring them back
 * then findout which nut Squirrel should find first to result the min distance
 * Time O(n)
 * Space constant
 */
public class SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {

        int sum = 0;
        for(int[] nut : nuts){
            int y = nut[0], x = nut[1];
            sum+=Math.abs(y-tree[0]) + Math.abs(x-tree[1]);
        }
        sum*=2;
        if(sum == 0) return 0;
        
        int res = Integer.MAX_VALUE;
        for(int[] nut : nuts){
            int y = nut[0], x = nut[1];
            int distToS = Math.abs(y-squirrel[0]) + Math.abs(x-squirrel[1]);
            int distToT = Math.abs(y-tree[0]) + Math.abs(x-tree[1]);
            res = Math.min(res, distToS+sum-distToT);
        }
        
        return res;
    }
}
