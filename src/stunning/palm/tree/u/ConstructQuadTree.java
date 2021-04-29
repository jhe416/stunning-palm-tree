package stunning.palm.tree.u;

public class ConstructQuadTree {
	public ConstructQuadTree() {}
	
    public Node construct(int[][] grid) {
        return helper(grid,0,grid.length-1,0,grid.length-1);
    }
    
    private Node helper(int[][] grid, int is, int ie, int js, int je){
        if(isSame(grid, is, ie, js, je)){
            return new Node(grid[is][js] == 1,true);
        }
        
        Node root = new Node();
        //(ie-is+1)/2
        //(je-js+1)/2
        root.topLeft = helper(grid, is, is+(ie-is)/2, js, js+(je-js)/2);
        root.topRight = helper(grid, is, is+(ie-is)/2, js+(je-js)/2+1, je);
        root.bottomLeft = helper(grid, is+(ie-is)/2+1, ie, js, js+(je-js)/2);
        root.bottomRight = helper(grid, is+(ie-is)/2+1, ie, js+(je-js)/2+1, je);
            
        return root;
    }
    
    private boolean isSame(int[][] grid, int is, int ie, int js, int je){
        if(is==ie && js == je) return true;
        boolean ones = false;
        boolean zeros = false;
        for(int i=is;i<=ie;i++){
            for(int j=js;j<=je;j++){
                if(grid[i][j] == 1) ones = true;
                else zeros = true;
                
                if(ones && zeros) return false;
            }
        }
        
        return true;
    }
    
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        
        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };   
}
