import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private ArrayDeque<T> frontier;

    public FrontierQueue(){
	frontier=new ArrayDeque<T>();
    }
    
    public void add(T element){
	frontier.add(element);
    }

    public T next(){
	return frontier.poll();
    }

    public boolean hasNext(){
	return !frontier.isEmpty();
    }
}
