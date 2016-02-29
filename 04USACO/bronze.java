import java.util.*;
import java.io.*;

public class Bronze{
    public static void main(String[]args){
	try{
	    Scanner in=new Scanner(new File("makelake.in"));
	    int R=in.nextInt();	
	    int C=in.nextInt();
	    int E=in.nextInt();
	    int N=in.nextInt();
	    int[][] pasture=new int[R][C];
	    for (int row=1;row<R+1;row++){
		for(int col=0;col<C;col++){
		    pasture[row-1][col]=in.nextInt();
		}
	    }
	    int[][] instructions=new int[N][3];
	    for (int row=0;row<N;row++){
		for(int col=0;col<3;col++){
		    instructions[row][col]=in.nextInt();
		}
	    }
	    for(int row=0;row<N;row++){
		pasture=stomp(instructions[row][0]-1,instructions[row][1]-1,instructions[row][2],pasture);
	    }
	    for(int rowE=0;rowE<pasture.length;rowE++){
		for(int colE=0;colE<pasture[0].length;colE++){
		    if(E-pasture[rowE][colE]<0){
			pasture[rowE][colE]=0;
		    }else{
			pasture[rowE][colE]=E-pasture[rowE][colE];
		    }
		}
	    }
	    int totDepth=0;
	    for(int rowL=0;rowL<pasture.length;rowL++){
		for(int colL=0;colL<pasture[0].length;colL++){
		    totDepth+=pasture[rowL][colL];
		}
	    }

	    System.out.println(72*72*totDepth+",7,Topa,Giovanni");
	}catch(FileNotFoundException e){
	    System.out.println("file not found");
	}
    }
    
    public static int[][] stomp(int R_s,int C_s,int D_s, int[][] pasture){
	int max=0;
	for (int row=R_s;row<R_s+3&&row<pasture.length;row++){
	    for(int col=C_s;col<C_s+3&&col<pasture[0].length;col++){
		if (pasture[row][col]>max){
			max=pasture[row][col];
		    }
	    }
	}
	int nDepth=max-D_s;
	for (int row=R_s;row<R_s+3&&row<pasture.length;row++){
	    for(int col=C_s;col<C_s+3&&col<pasture[0].length;col++){
		if (pasture[row][col]>=nDepth){
		    pasture[row][col]=nDepth;
		}
	    }
	}
	return pasture;
    }
    public static void printArray(int[][] array){
	for (int row=0;row<array.length;row++){
	    for(int col=0;col<array[0].length;col++){
		System.out.print(array[row][col]+"\t");
	    }
	    System.out.println();
	}
    }
}
