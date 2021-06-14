package stunning.palm.tree.u;

public class DesignTicTacToe {
	public DesignTicTacToe() {}
	
    /** Initialize your data structure here. */
    int[] rows;
    int[] cols;
    int[] diag1;
    int[] diag2;
    int n;
    public DesignTicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag1 = new int[2*n-1];
        this.diag2 = new int[2*n-1];
        this.n = n;
    }
    //xxxx
    //xxxx
    //xxxx
    //xxxx
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] = player == 1? rows[row]+1 : rows[row]-1;
        cols[col] = player == 1? cols[col]+1 : cols[col]-1;
        diag1[row+col] = player == 1? diag1[row+col]+1 : diag1[row+col]-1;
        diag2[n+(row-col)-1] = player == 1? diag2[n+(row-col)-1]+1 : diag2[n+(row-col)-1]-1;
        
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag1[row+col]) == n || Math.abs(diag2[n+(row-col)-1]) == n) return player;
        return 0;
    }
}
