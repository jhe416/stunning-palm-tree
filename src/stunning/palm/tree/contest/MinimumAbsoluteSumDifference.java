package stunning.palm.tree.contest;

public class MinimumAbsoluteSumDifference {
	public MinimumAbsoluteSumDifference() {}
	
    int mod = 1000000000+7;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] max = new int[]{0,Integer.MIN_VALUE};
        int n = nums1.length;

        for(int i=0;i<n;i++){
            if(Math.abs(nums1[i] - nums2[i]) > max[1]){
                max = new int[]{i,Math.abs(nums1[i] - nums2[i])};
            }
        }

        int target = nums2[max[0]];
        int[] replace = new int[]{0,Integer.MAX_VALUE};
        for(int i=0;i<n;i++){
            int diff = Math.abs(nums1[i] - target);
            if(diff < replace[1]){
                replace = new int[]{i,diff};
            }
        }

        nums1[max[0]] = nums1[replace[0]];
        
        int res = 0;
        for(int i=0;i<n;i++){
            res = (Math.abs(nums1[i] - nums2[i]) + res)%mod;
        }
        
        return res;
    }
}
