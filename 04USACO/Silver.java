import java.io.*;
import java.util.*;

public class Silver{
    public static void main(String[]args){
	try{
	    Scanner in = new Scanner(new File("ctravel.in"));
	    int N=in.nextInt();
	    int M=in.nextInt();
	    int T=in.nextInt();
	    in.nextLine();
	    int[][] pasture=new int[N][M];
	    String[] rows=new String[N];
	    for(int row=0;row<N;row++){
		rows[row]=in.nextLine();
	    }
	    for(int n=0;n<rows.length-1;n++){
		for (int m=0;m<M;m++){
		    if (rows[n].charAt(m)=='*'){
			pasture[n][m]=-1;
		    }
		}
	    }
	    printArray(pasture);
	    int R1=in.nextInt();
	    int C1=in.nextInt();
	    int R2=in.nextInt();
	    int C2=in.nextInt();
	    pasture[R1-1][C1-1]=1;
	    pasture=solve(pasture,T);
	    System.out.println(pasture[R2-1][C2-1]);
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	}
    }

    public static int[][] solve(int[][] pasture, int moves){
	printArray(pasture);
	if (moves==0){
	    return pasture;
	}else{
	    int[][] pasture1=new int[pasture.length][pasture[0].length];
	    for(int i=0;i<pasture.length*pasture[0].length;i++){
		if(pasture[i/pasture.length][i%pasture.length]!=-1){
		    pasture1[i/pasture.length][i%pasture[0].length]=sumNeighbors(pasture,i/pasture.length,i%pasture.length);
		}else{
		    pasture1[i/pasture1.length][i%pasture1[0].length]=-1;
		}
	    }
	    return solve(pasture1,moves-1);
	}
    }

    public static int sumNeighbors(int[][] pasture,int row, int col){
	return sum(pasture,row+1,col)+sum(pasture,row-1,col)+sum(pasture,row,col+1)+sum(pasture,row,col-1);
    }

    public static int sum(int[][]pasture, int row, int col){
	if(row>=0&&col>=0&&row<pasture.length&&col<pasture.length&&pasture[row][col]!=-1){
	    return pasture[row][col];
	}else{
	    return 0;
	}
    }
    public static void printArray(int[][] data){
	for(int j=0;j<data.length;j++){
	    for (int i=0;i<data[0].length;i++){
		System.out.print(data[j][i]);
	    }
	    System.out.println();
	}
	System.out.println();
    }

}
    
