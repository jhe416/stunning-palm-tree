package stunning.palm.tree.a;

/*
 * having 4 properties, whichever reaches n we know the player 1 win
 * whichever reaches -n we know player 2 win
 * the tricky thing here is we will need a diag1 and diag2 to keep track the diagonal counts;
 * Time O(n)
 * Space O(n)
 */
public class DesignTicTacToe {
    /** Initialize your data structure here. */
    int[] cols;
    int[] rows;
    int diag1;
    int diag2;
    int n;
    public DesignTicTacToe(int n) {
        this.cols = new int[n];
        this.rows = new int[n];
        this.diag1 = 0;
        this.diag2 = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        cols[col] = player == 1? ++cols[col] : --cols[col];
        rows[row] = player == 1? ++rows[row] : --rows[row];
        
        diag1 = row == col? player == 1? ++diag1 : --diag1 : diag1;
        diag2 = 1+col+row == n? player == 1? ++diag2 : --diag2 : diag2;  

        if(cols[col] == n || rows[row] == n || diag1 == n || diag2 == n) return 1;
        else if(cols[col] == -n || rows[row] == -n || diag1 == -n || diag2 == -n) return 2;
        return 0;
    }
}
