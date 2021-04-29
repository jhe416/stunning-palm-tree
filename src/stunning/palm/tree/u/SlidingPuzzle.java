package stunning.palm.tree.u;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
	public SlidingPuzzle() {}
	
    int[][] state = {{1,2,3},{4,5,0}};
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int slidingPuzzle(int[][] board) {
        if(valid(board)) return 0;
        int m = 2;
        int n = 3;
        Set<Data> set = new HashSet<>();
        Queue<Data> q = new LinkedList<>();
        
        outer:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 0){
                    q.offer(new Data(i,j,board));
                    set.add(q.peek());
                    break outer;
                }
            }
        }
        
        int res = 0;
        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                Data pos = q.poll();
                for(int[] dir : dirs){
                    int y = dir[0] + pos.i;
                    int x = dir[1] + pos.j;
                    if(x<0 || x == n || y <0 || y == m) continue;
                    Data newData = new Data(y,x,pos.board);
                    swap(newData.board,pos.i,pos.j,y,x);
                    if(!set.add(newData)) continue;
                    q.offer(newData);
                    if(valid(newData.board)) return res+1;
                }
            }
            res++;
        }
        
        
        return -1;
    }
    
    private void swap(int[][] board,int i, int j, int y, int x){
        int tmp = board[i][j];
        board[i][j] = board[y][x];
        board[y][x] = tmp;
    }
    
    private boolean valid(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != state[i][j]) return false;
            }
        }
        return true;
    }
}

class Data{
    public int i;
    public int j;
    public int[][] board;
    
    public Data(int i, int j, int[][] board){
        this.i = i;
        this.j = j;
        this.board = new int[board.length][board[0].length];
        for(int k=0;k<board.length;k++){
            for(int z=0;z<board[0].length;z++){
                this.board[k][z] = board[k][z];
            }
        }
    }
    
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Data)) return false;
        Data objData = (Data)obj;
        return sameBoard(objData.board);
    }
    
    private boolean sameBoard(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(this.board[i][j] != board[i][j]) return false;
            }
        }   	
    	return true;
    }
    
    @Override
    public int hashCode(){
        int hashCode = 7;
        hashCode = hashCode*31 + board[0][0];
        hashCode = hashCode*31 + board[0][1];
        hashCode = hashCode*31 + board[0][2];
        hashCode = hashCode*31 + board[1][0];
        hashCode = hashCode*31 + board[1][1];
        hashCode = hashCode*31 + board[1][2];
        return hashCode;
    }
}
