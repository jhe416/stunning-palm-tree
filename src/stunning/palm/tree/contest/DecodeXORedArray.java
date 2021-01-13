package stunning.palm.tree.contest;

/*
 * a xor x = c;
 * a xor c = x;
 * Time O(n)
 * Space O(n)
 */
public class DecodeXORedArray {
	public DecodeXORedArray() {}
	
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length+1];
        res[0] = first;
        for(int i=0;i<encoded.length;i++){
            res[i+1] = res[i] ^ encoded[i];
        }
        
        return res;
    }
}
