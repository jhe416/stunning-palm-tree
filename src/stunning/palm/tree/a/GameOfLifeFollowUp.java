package stunning.palm.tree.a;

import java.util.*;

public class GameOfLifeFollowUp {
	
	public GameOfLifeFollowUp() {}
	
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        Set<Coor> lives = new HashSet<>();
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(board[i][j] == 1) {
        			lives.add(new Coor(i,j));
        		}
        	}
        }
        
        lives = gameOfLifeFollowUp(lives);
        
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(lives.contains(new Coor(i,j))) {
        			board[i][j] = 1;
        		}else {
        			board[i][j] = 0;
        		}
        	}
        }
    }
    
	public Set<Coor> gameOfLifeFollowUp(Set<Coor> lives) {
        Map<Coor,Integer> map = new HashMap<>();
        
        for(Coor coor : lives) {
        	for(int i=coor.i-1;i<coor.i+2;i++) {
        		for(int j=coor.j-1;j<coor.j+2;j++) {
        			if(i == coor.i && coor.j == j) continue;
        			Coor newCoor = new Coor(i,j);
        			map.put(newCoor, map.getOrDefault(newCoor, 0)+1);
        		}
        	}
        }
        
        Set<Coor> res = new HashSet<>();
        for(Map.Entry<Coor,Integer> entry : map.entrySet()) {
        	if(entry.getValue() == 3 || entry.getValue() == 2 && lives.contains(entry.getKey())) {
        		res.add(entry.getKey());
        	}
        }
        
        return res;
    }

}

class Coor{
	public int i;
	public int j;
	
	public Coor(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Coor)) return false;
		Coor oCoor = (Coor) o;
		return oCoor.i == this.i && oCoor.j == this.j;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 1;
		hashCode = 31*hashCode + this.i;
		hashCode = 31*hashCode + this.j;
		return hashCode;
	}
}