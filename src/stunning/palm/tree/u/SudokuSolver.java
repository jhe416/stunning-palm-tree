package stunning.palm.tree.u;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {
    Map<Integer,Set<Character>> rows = new HashMap<>();
    Map<Integer,Set<Character>> cols = new HashMap<>();
    Map<Integer,Set<Character>> grids = new HashMap<>();
    Map<Position,Integer> map = new HashMap<>();
    
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        int m=board.length,n=board[0].length;
        
        int num=0;
        for(int gi=0;gi<3;gi++){
            for(int gj=0;gj<3;gj++){
                num++;
                for(int i=gi*3;i<gi*3+3;i++){
                    for(int j=gj*3;j<gj*3+3;j++){
                        char c = board[i][j];
                        rows.putIfAbsent(i,new HashSet<>());
                        cols.putIfAbsent(j,new HashSet<>());
                        Position pos = new Position(i,j);
                        map.put(pos,num);
                        grids.putIfAbsent(num,new HashSet<>());    
                        if(c == '.')continue;
                        rows.get(i).add(c); cols.get(j).add(c); grids.get(map.get(pos)).add(c);
                    }
                }
            }
        }
        
       helper(board,m,n,0,0); 
    }
    
    public boolean helper(char[][] board, int m, int n, int i, int j){
    	if(i == m) {
    		return true;
    	}

    	if(board[i][j] == '.'){
    		Position pos = new Position(i,j);
    		for(char c='1';c<='9';c++){
    			if(!rows.get(i).contains(c) && !cols.get(j).contains(c) && !grids.get(map.get(pos)).contains(c)){
    				board[i][j] = c;
    				rows.get(i).add(c); cols.get(j).add(c); grids.get(map.get(pos)).add(c);
    				if(j+1<n){
    					if(helper(board,m,n,i,j+1)) return true;
    				}else{
    					if(helper(board,m,n,i+1,0)) return true;
    				}
    				rows.get(i).remove(c); cols.get(j).remove(c); grids.get(map.get(pos)).remove(c);
    				board[i][j] = '.';
    			}
    		}  
    		return false;
    	}else{
    		if(j+1<n){
    			if(helper(board,m,n,i,j+1)) return true;
    		}else{
    			if(helper(board,m,n,i+1,0)) return true;
    		}            
    	}

    	return false;
    }
}

class Position{
    public int i;
    public int j;
    
    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Position){
            Position data = (Position)obj;
            return data.i == i && data.j == j;
        }
        
        return false;
    }
    
    @Override
    public int hashCode(){
        int hash = 10;
        hash=hash*6+this.i;
        hash=hash*6+this.j;
        
        return hash;
    }
}
