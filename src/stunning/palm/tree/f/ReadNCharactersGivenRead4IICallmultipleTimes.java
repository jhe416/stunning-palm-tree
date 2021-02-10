package stunning.palm.tree.f;

/*
 * key to understand this problem is to load buffer using read4
 * and then load contain in the buffer to buf arr in the input param
 */
public abstract class ReadNCharactersGivenRead4IICallmultipleTimes {
	public ReadNCharactersGivenRead4IICallmultipleTimes() {}
	
    private int size = -1;
    private int index = 0;
    private char[] buffer = new char[4];
    public int read(char[] buf, int n) {            
        if(size == -1){
            size = read4(buffer);
            index = 0;
        }
        if(size == 0) return 0;
        
        for(int i=0;i<n;i++){
            buf[i] = buffer[index++];
            if(index == size){
                size = read4(buffer);
                index = 0;
            }
            if(size == 0){
                return i+1;
            }
        }
        
        
        return n;
    }
    
    abstract int read4(char[] buf4); 
}

