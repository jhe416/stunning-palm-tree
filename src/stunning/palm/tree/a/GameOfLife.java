package stunning.palm.tree.a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * cell dies if 2 less or 3 more
 * cell live if neighbor cells live 3
 * Time O(n)
 * space constant
 */
public class GameOfLife {
	public GameOfLife() {}
	
    public void gameOfLife(int[][] board) {
        Set<Integer> dead = new HashSet<>(Arrays.asList(0,2));//2 dead to live;
        Set<Integer> live = new HashSet<>(Arrays.asList(1,3));//3 live to dead;
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives = 0;
                for(int[] dir : dirs){
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(x <0 || x>= m || y<0 || y>=n) continue;
                    if(live.contains(board[x][y]))lives++;  
                }
                if(lives < 2 || lives >3) board[i][j] = board[i][j] == 0? board[i][j] : 3;
                else if(lives == 3) board[i][j] = board[i][j] == 0? 2 : board[i][j];
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2) board[i][j] =1;
                else if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
}
