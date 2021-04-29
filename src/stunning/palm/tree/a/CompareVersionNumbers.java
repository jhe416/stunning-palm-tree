package stunning.palm.tree.a;

public class CompareVersionNumbers {
	public CompareVersionNumbers() {}
	
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i=0,j=0;
        for(; i<arr1.length && j<arr2.length;i++,j++){
            int val1 = Integer.valueOf(arr1[i]);
            int val2 = Integer.valueOf(arr2[j]);
            if(val1 < val2) return -1;
            if(val1 > val2) return 1;
        }
        
        while(i<arr1.length){
            if(Integer.valueOf(arr1[i++]) > 0) return 1;
        }
        while(j<arr2.length){
            if(Integer.valueOf(arr2[j++]) > 0) return -1;
        }
        return 0;
    }
}
