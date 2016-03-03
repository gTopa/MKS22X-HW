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
	    R=first.split()[0];	
	    C=first.split()[1];
	    E=first.split()[2];
	    N=first.split()[3];
	    String[] past=[];
	    for(int i=1;i<=R+1;i++){
		past+=in.readline();
	    }
	    
	}catch(){

	}
