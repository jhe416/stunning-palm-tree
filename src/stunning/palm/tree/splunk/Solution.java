package stunning.palm.tree.splunk;

public class Solution {
	public Solution() {}
 public int[] solution(int[] nums) {
	 if(nums == null || nums.length == 0) return null;
	 int[] arr1 = new int[nums.length];
	 int[] arr2 = new int[nums.length];
	 
	 int i=0,j=nums.length-1;
	 int s=1,e=1;
	 while(i<nums.length && j>=0) {
		 arr1[i] = s*nums[i];
		 arr2[j] = e*nums[j];
		 s=arr1[i];
		 e=arr2[j];
		 i++;
		 j--;
	 }
	 
	 int[] res = new int[nums.length];
	 for(i=0;i<res.length;i++) {
		 int val1 = i-1<0? 1: arr1[i-1];
		 int val2 = i+1==nums.length? 1 : arr2[i+1];
		 res[i]=val1*val2;
	 }
	 
	 return res;
 }
 
 public static void main(String[] args) {
	 Solution sol = new Solution();
	 
	 int[] res = sol.solution(new int[] {1,2,3,4});
	 
	 for(int val : res) {
		 System.out.println(val);
	 }
 }
}
