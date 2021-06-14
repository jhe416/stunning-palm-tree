package stunning.palm.tree.u;
import java.util.*;
public class OnSiteDirectGraphMinCostToAPoint {
	public OnSiteDirectGraphMinCostToAPoint() {}
	
	public static void main(String[] args) {
		OnSiteDirectGraphMinCostToAPoint sol = new OnSiteDirectGraphMinCostToAPoint();
		int[][][] graph = {{{1,1,1},{3,1,2}},{{3,2,2},{1,1,3}},{{5,5,0},{3,1,4}},{{3,6,2},{1,1,4}},{{0,0,4}}};
		System.out.println(sol.minCost(graph, 0, 4, 5));
	}
	//{{{1,1,1},{3,1,2}},{{3,2,2},{1,1,3}},{{5,5,0},{3,1,4}},{{3,6,2},{1,1,4}},{{0,0,4}}} //time,cost,node
	public int minCost(int[][][] graph, int start, int end, int timeMax) {
		Queue<Data> q = new LinkedList<>(Arrays.asList(new Data(start)));
		Set<Integer> visited = new HashSet<>();
		int res = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			for(int k=q.size();k>0;k--) {
				Data data = q.poll();
				for(var val : graph[data.node]) {
					Data newData = new Data(data.time+val[0],data.cost+val[1],val[2]);
					if(newData.time>timeMax || !visited.add(newData.node)) continue;
					if(newData.node == end) {
						res = Math.min(res, newData.cost);
					}else {
						q.offer(newData);
					}
				}
			}
		}
		
		return res == Integer.MAX_VALUE? -1 : res;
	}
	
	class Data{
		int node;
		int time;
		int cost;
		public Data(int node) {
			this.node = node;
			this.time=0;
			this.cost=0;
		}
		
		public Data(int time, int cost, int node) {
			this.node = node;
			this.time = time;
			this.cost = cost;
		}
	}
}
