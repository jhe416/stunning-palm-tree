package stunning.palm.tree.contest;

<<<<<<< HEAD

//ConcatenationOfArray
=======
>>>>>>> cd54280f1207ef6abd8c91d6506210304010b28b
//testing 123
public class ConcatenationOfArray {
	public ConcatenationOfArray() {}
	
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            res[i] = nums[i];
        }
        int n = nums.length;
        for(int i=n;i<res.length;i++){
            res[i] = nums[i-n];
        }
        
        return res;
    }
}
