public class KnightBoard{
    private int[][] board;

    public KnightBoard(int col, int row){
	board = new int[row+4][col+4];
	for (int i=0;i<(row+4)*(col+4);i++){
	    if (i/(col+4)==0||i/(col+4)==row+3||i%(col+4)==0||i%(col+4)==col+3||i/(col+4)==1||i/(col+4)==row+2||i%(col+4)==1||i%(col+4)==col+2){
		board[i/(col+4)][i%(col+4)]=-1;
	    }
	}

    }

    public boolean solve(){
	return solveH(2,2,1);
    }

    public boolean solveH(int row, int col, int turn){
	if (turn==(board.length-4)*(board[0].length-4)){
	    return moveKnight(turn,row,col);
	}else{
	    if(moveKnight(turn,row,col)){
		if(solveH(row + 2,col+1,turn+1) ||
		   solveH(row + 2,col-1,turn+1) ||
		   solveH(row - 2,col+1,turn+1) ||
		   solveH(row - 2,col-1,turn+1) ||
		   solveH(row + 1,col+2,turn+1) ||
		   solveH(row + 1,col-2,turn+1) ||
		   solveH(row - 1,col+2,turn+1) ||
		   solveH(row - 1,col+2,turn+1)){
		    return true;
		}else{
		    removeKnight(row,col);
		}
	    }
	}
	return false;
    }

    public void printSolution(){
	int rowL=board.length;
	int colL=board[0].length;
	for (int row=0;row<rowL;row++){
	    for(int col=0;col<colL;col++){
		if (board[row][col]>=0){
		    if(rowL*colL>10){
			if (board[row][col]/10>0){
			    System.out.print(board[row][col]+" ");
			}else{
			    System.out.print(" "+board[row][col]+" ");
			}
		    }else{
			System.out.print(board[row][col]+" ");
		    }
		}
	    }
	    System.out.println();
	}
    }
    
    public boolean moveKnight(int turn, int row, int col){
	if (board[row][col]==0){
	    board[row][col]=turn;
	    return true;
	}else{
	    return false;
	}
    }

    public boolean removeKnight(int row, int col){
	if (board[row][col]>0){
	    board[row][col]=0;
	    return true;
	}else{
	    return false;
	}
    }
    
    public void printBoard(){
	for (int i=0;i<board.length;i++){
	    for (int c=0;c<board[0].length;c++){
		System.out.print(board[i][c]);
	    }
	    System.out.println();
	}
    }
}
