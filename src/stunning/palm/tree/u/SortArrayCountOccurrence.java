package stunning.palm.tree.u;

//SortArrayCountOccurrence
public class SortArrayCountOccurrence {
	public SortArrayCountOccurrence() {}
	
	public int count(int[] arr, int val) {
		int s=0,e=arr.length-1;
		int j = 0;
		while(s<e) {
			int mid = s + (e-s)/2;
			if(arr[mid] > val) {
				e = mid;
			}else {
				s = mid+1;
			}
		}
		j=s==arr.length-1? s+1 : s;
		
		s=0;e=arr.length-1;
		int i=0;
		while(s<e) {
			int mid = s + (e-s)/2;
			
			if(arr[mid]<val) {
				s=mid+1;
			}else {
				e=mid;
			}
			
		}
		i=s;
		
		return j-i;
	}
	
	public static void main(String[] args) {
		SortArrayCountOccurrence sol = new SortArrayCountOccurrence();
		
		System.out.println(sol.count(new int[]{1,1,1,2,2,2,2,2,3,3,3,4,6,6,6,12,12,12}, 2));
	}
}
