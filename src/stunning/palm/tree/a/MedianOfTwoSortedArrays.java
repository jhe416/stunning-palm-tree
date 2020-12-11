package stunning.palm.tree.a;

/*
 * binary search on cutting the array. imaging that the given arrays can be split into two half for each of them
 * the left half is the smaller half while the right half is the bigger half
 * we then binary search on below conditions:
 * l1 > r2 we shift smaller if l2 > r1 we shift bigger
 * if both condition satisfies we return based on the array length if is even or odd.
 * Time O(nloh(n)) space constant
 */
public class MedianOfTwoSortedArrays {
	public MedianOfTwoSortedArrays() {}

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	//always pick the smaller nums as it will give you less binary search
        //also this will solve the special case where an array is length of 1
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2,nums1);
        int n = nums1.length+nums2.length;
        int l = 0; int r = nums1.length;
        while(l<=r){
            int mid1 = l + (r-l)/2;
            int mid2 = n/2 - mid1;
            
            int r1 = mid1 >= 0 && mid1 < nums1.length? nums1[mid1] : Integer.MAX_VALUE;
            int l1 = mid1-1 >=0 && mid1-1 <nums1.length? nums1[mid1-1] :Integer.MIN_VALUE;
            int r2 = mid2 >= 0 && mid2 < nums2.length? nums2[mid2] : Integer.MAX_VALUE;
            int l2 = mid2-1 >=0 && mid2-1 <nums2.length? nums2[mid2-1] : Integer.MIN_VALUE;
            
            if(l1 > r2){
                r = mid1;
            }else if(l2 > r1){
                l = mid1+1;
            }else{
                if(n%2 == 0)
                {
                    int val1 = Math.max(l1,l2);
                    int val2 = Math.min(r1,r2);
                    return Double.valueOf(val1+val2)/Double.valueOf(2);
                }
                else
                {
                    return Double.valueOf(Math.min(r1,r2));   
                }
            }
        }
        
        return 0.0;
    }
}
