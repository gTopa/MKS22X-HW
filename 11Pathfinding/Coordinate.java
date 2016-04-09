import java.util.*;

public class Coordinate{
    private int x;
    private int y;
    private ArrayList<int[]> history;

    public Coordinate(int x, int y){
	this.x=x;
	this.y=y;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public ArrayList<int[]> getHistory(){
	return history;
    }

    public void addToHistory(int newX, int newY){
	history.add({newX, newY});
    }
}
