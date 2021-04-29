package stunning.palm.tree.s;

import java.util.HashMap;
import java.util.Map;

public class ApiRateLimiter {
  public static void main(String[] args) {
	  ApiRateLimiter r = new ApiRateLimiter(3,2);
	  r.addUser("jay", new ApiRateLimiter(3,2));
	  
	  System.out.println(r.rateLimit("jay",10));
	  System.out.println(r.rateLimit("jay",11));
	  System.out.println(r.rateLimit("jay",11));
	  System.out.println(r.rateLimit("jay",11)); // false
	  System.out.println(r.rateLimit("jay",12));
  }
	
	
  Map<Integer,Integer> map = new HashMap<>();
  Map<String,ApiRateLimiter> userMap = new HashMap<>();
  
  int max;
  int num;
  
  public ApiRateLimiter(int num,int max) {
	  this.max = max;
	  this.num = num;
  }
  
  public boolean rateLimit(int time) {
	 int sum = 0;
	 
	 for(int i=0;i<max;i++) {
		 sum+=map.getOrDefault(time-i, 0);
		 if(sum >= num) {
			 return false;
		 }
	 }
	 
	 map.put(time, map.getOrDefault(time, 0)+1);
	 return true;
  }
  
  public boolean rateLimit(String name, int time) {
	 int sum = 0;
	 ApiRateLimiter limiter = userMap.get(name);
	 for(int i=0;i<max;i++) {
		 sum+=limiter.map.getOrDefault(time-i, 0);
		 if(sum >= num) {
			 return false;
		 }
	 }
	 
	 limiter.map.put(time, limiter.map.getOrDefault(time, 0)+1);
	 return true;
  }
  
  public void addUser(String name, ApiRateLimiter limiter) {
	  userMap.put(name, limiter);
  }
}
