public class Board{
    private int[][] board;

    public Board(int n){
	board=new int[n][n];
    }

    public boolean addQueen(int row, int col){
	if(board[row][col]==0){
	    board[row][col]=1;
	    fixBoard(-1,row,col);
	    return true;
	}else{
	    return false;
	}
    }

    public boolean removeQueen(int row,int col){
	if (board[row][col]==1){
	    board[row][col]=0;
	    fixBoard(1,row,col);
	    return true;
	}else{
	    return false;
	}
    }
    
    public void fixBoard(int change, int row, int col){
	if (change>0){
	    for (int i=0;i<board.length*board.length;i++)
		if (board[i/board.length][i%board.length]<0){
		    board[1/board.length][i%board.length]+=1;
		}
	}else{
	    for (int i=1;i<board.length-col;i++){
		board[row][col+i]-=1;
	    }
	    for (int i=1;i<board.length-col&&i<board.length-row;i++){
		board[row+i][col+i]-=1;
	    }
	    for (int i=1;i<board.length-col&&i<row+1;i++){
		board[row-i][col+i]-=1;
	    }
	}
    }
    public String toString(){
	String thing="";
	for (int row=0;row<board.length;row++){
	    for (int col=0;col<board.length;col++){
		thing+=board[row][col]+" ";
	    }
	    thing+="\n";
	}
	return thing;
    }
}
	
