public class Bronze{

    public int R;
    public int C;
    public int E;
    public int N;
    public int[][] pasture;
    public String[] instructions;

    public static void main(String[]args){
	try{
	    BufferedReader in=new BufferedReader(new File("makelake.in")); \
	    String first=in.readline();
	    R=Integer.parseInt(first.split()[0]);	
	    C=Integer.parseInt(first.split()[1]);
	    E=Integer.parseInt(first.split()[2]);
	    N=Integer.parseInt(first.split()[3]);
	    String[] past=[];
	    for(int i=1;i<=R+1;i++){
		past+=in.readline();
	    }
	    for (int r=0;r<past.length;r++){
		String[] row=past[r].split();
		for(int c=0;c<row.length;c++){
		    pasture[r][c]=Integer.parseInt(row[c]);
		}
	    }
	    instructions=new int[N]
	    for (int j=0;j<R+1+N;j++){
		instructions[j]=in.readline();
	    }
	}catch(FileNotFoundException e){
	    System.out.println("file not found");
	}
	for(int l=0;l<N;l++){
	    stomp(Integer.parseInt(first.split()[0]),Integer.parseInt(first.split()[1]),Integer.parseInt(first.split()[2]));
	}
	for(int rowE=0;rowE<pasture.length;rowE++){
	    for(int colE=0;colE<pasture.length;colE++){
		if(E-pasture[rowE][colE]<0){
		    pasture[rowE][colE]=0;
		}else{
		    pasture[rowE][colE]=E-pasture[rowE][colE];
		}
	    }
	}
    }
}
