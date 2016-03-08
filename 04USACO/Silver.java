import java.io.*;
import java.util.*;

public class Silver{
    public static void main(String[]args){
	Scanner in = new Scanner(new File("ctravel.in"));
	int N=in.nextInt();
	int M=in.nextInt();
	int T=in.nextInt();
	int[][] pasture=new int[N][M];
	String[] rows=new String[N];
	for(int row=0;row<N;row++){
	    rows[row]=in.nextLine();
	}
	for(int n=0;n<N;n++){
	    for (int m=0;m<M;m++){
		if (rows[n].charAt(m)=='*'){
		    pasture[n][m]=-1;
		}
	    }
	}
	int R1=in.nextInt();
	int C1=in.nextInt();
	int R2=in.nextInt();
	int C2=in.nextInt();
	pasture[R1][C1]=1;
        solve(pasture,T);
	System.out.println(pasture[R2][C2]);
    }

    public static int[][] solve(int[][] pasture, int moves){
	if (moves==0){
	    return pasture;
	}else{
	    for(int i=0;i<pasture.length*pasture[0].length;i++){
		pasture[i/pasture.length][i%pasture[0].length]=sumNeighbors(pasture,i/pasture.length,i%pasture.length);
	    }
	    solve(pasture,moves-1);
	}
    }
	public static int sumNeighbors(int[][] pasture,int row, int col){
	    if(row==0 && col==0){
		return pasture[1][0]+pasture[0][1];
	    }else if(row==0&&col==pasture[0].length-1){
		return pasture[0][pasture[0].length-2]+pasture[1][pasture[0].length-1];
	    }else if (col==0&&row==pasture.length-1){
		return pasture[pasture.length-2][0]+pasture[pasture.length-1][1];
	    }else if(col==pasture[0].length&&row==pasture.length){
		return pasture[pasture.length-1][pasture.length[0]-2]+pasture[pasture.length-2][pasture[0].length-1];
	    }else{
	    
}
    
