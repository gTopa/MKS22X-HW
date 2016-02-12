public class KnightBoard{
    private int[][] board;

    public KnightBoard(int n){
	board = new int[n+4][n+4];
	for (int i=0;i<(n+4)*(n+4);i++){
	    if (i/(n+4)==0||i/(n+4)==n+3||i%(n+4)==0||i%(n+4)==n+3||i/(n+4)==1||i/(n+4)==n+2||i%(n+4)==1||i%(n+4)==n+2){
		board[i/(n+4)][i%(n+4)]=-1;
	    }
	}

    }

    public boolean solve(){
	solveH(board.length/2,board.length/2,1);
    }

    public boolean solveH(int row, int col, int turn){
	if (turn==(board.length-4)*(board.length-4)+1&&board[row][col]==1){
	    return true;
	}
    }

    public boolean printSolution(){
    }

    public boolean moveKnight(int turn, int row, int col){
	if (board[row][col]==0){
	    board[row][col]=turn;
	    return true;
	}else{
	    return false;
	}
    }
