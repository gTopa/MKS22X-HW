import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	private int x;
	private int y;
	private Node prev;

	public Node(int x, int y, Node prev){
	    this.x=x;
	    this.y=y;
	    this.prev=prev;
	}
	
	public int getX(){
	    return x;
	}
	
	public int getY(){
	    return y;
	}
	public Node getPrev(){
	    return prev;
	}
    }

    private char[][] maze;
    private ArrayList<Integer> solution;
    private int startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/      
	return new int[1];
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
	placesToGo=new FrontierQueue<Node>();
	return solve();
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
	placesToGo=new FrontierStack<Node>();
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){  
	Node next=new Node(startRow,startCol,null);
	maze[next.getX()][next.getY()] = '.';
	while(placesToGo.hasNext()){
	    for(Node n : getNeighbors(next)){
		if(maze[n.getX()][n.getY()]=='E') {
		    while(n.getPrev()!=null) {
			maze[n.getX()][n.getY()] = '*';
			solution.add(0,n.getY());
			solution.add(0,n.getX());
			n = n.getPrev();
		    }
		    return true;
		}
		else{
		    maze[n.getX()][n.getY()] = '.';
		    placesToGo.add(n);
		}
		if (animate){
		    System.out.println(toString());
		}
	    }
	}
	return false;
    }    
     
    private boolean checkEnd(Node next){
	return maze[next.getX()][next.getY()]=='E';
    }

    private ArrayList<Node> getNeighbors(Node next){
	int row=next.getX();
	int col=next.getY();
	ArrayList<Node> neighbors=new ArrayList<Node>();
	if(maze[row-1][col]!='.'&&maze[row-1][col]!='#'){
	    neighbors.add(new Node(row-1,col,next));
	}
	if(maze[row+1][col]=='.'&&maze[row+1][col]=='#'){
	    neighbors.add(new Node(row+1,col,next));
	}
	if(maze[row][col+1]=='.'&&maze[row][col+1]=='#'){
	    neighbors.add(new Node(row,col+1,next));
	}
	if(maze[row][col+1]=='.'&&maze[row][col+1]=='#'){
	    neighbors.add(new Node(row,col-1,next));
	}
	return neighbors;
    }

   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){ 
	animate=b;
    }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    }
    public static void main(String[]args){
	BetterMaze t1=new BetterMaze("data1.dat");
	t1.setAnimate(true);
	System.out.println(t1.solveBFS());
    }
}
