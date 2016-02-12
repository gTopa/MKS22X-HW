public class KnightBoard{
    private int[][] board;

    public KnightBoard(int col, int row){
	board = new int[row+4][col+4];
	for (int i=0;i<(row+4)*(col+4);i++){
	    if (i/(row+4)==0||i/(row+4)==row+3||i%(col+4)==0||i%(col+4)==col+3||i/(row+4)==1||i/(row+4)==row+2||i%(col+4)==1||i%(col+4)==col+2){
		board[i/(row+4)][i%(col+4)]=-1;
	    }
	}

    }

    public boolean solve(){
	return solveH(board.length/2,board[0].length/2,1);
    }

    public boolean solveH(int col, int row, int turn){
	if (turn==(board.length-4)*(board.length-4)+1&&board[row][col]==1){
	    return true;
	}else{
	    for (int i=0;i<8;i++){
		if (i==0){
		    if (moveKnight(turn,row+2,col+1)){
			return solveH(col+1,row+2,turn+1);
		    }
		}else if (i==1){
		    if (moveKnight(turn,row+2,col-1)){
			return solveH(col-1,row+2,turn+1);
		    }
		}else if (i==2){
		    if (moveKnight(turn,row-2,col+1)){
			return solveH(col+1,row-2,turn+1);
		    }
		}else if (i==3){
		    if (moveKnight(turn,row-2,col-1)){
			return solveH(col-1,row-2,turn+1);
		    }
		}else if (i==4){
		    if (moveKnight(turn,row+1,col+2)){
			return solveH(col+2,row+1,turn+1);
		    }
		}else if (i==5){
		    if (moveKnight(turn,row+1,col-2)){
			return solveH(col-2,row+1,turn+1);
		    }
		}else if (i==6){
		    if (moveKnight(turn,row-1,col-2)){
			return solveH(col-2,row-1,turn+1);
		    }
		}else{
		    if (moveKnight(turn,row-1,col+2)){
			return solveH(col+2,row-1,turn+1);
		    }
		}
	    }
	    return false;
	}
    }

    public void printSolution(){
	int rowL=board.length;
	int colL=board[0].length;
	for (int row=0;row<rowL;row++){
	    for(int col=0;col<colL;col++){
		if (!(row/(rowL)==0||row/(rowL)==rowL-3||col%(colL)==0||col%(colL)==colL-3||row/(rowL)==1||row/(rowL)==rowL-2||col%(colL)==1||col%(colL)==colL-2)){
		    System.out.println(board[row/rowL][col%colL]);
		}
	    }
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

    public void printBoard(){
	for (int i=0;i<board.length;i++){
	    for (int c=0;c<board[0].length;c++){
		System.out.print(board[i][c]+" ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[]args){
	KnightBoard b1=new KnightBoard(5,5);
	b1.printBoard();
	System.out.println(b1.solve());
	b1.printSolution();
    }
}
