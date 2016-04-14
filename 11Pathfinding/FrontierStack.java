import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    private Stack<T> frontier;

    public FrontierStack(){
	frontier=new Stack<T>();
    }
    
    public void add(T element){
	frontier.push(element);
    }

    public T next(){
	return frontier.pop();
    }

    public boolean hasNext(){
	return !frontier.empty();
    }
}
