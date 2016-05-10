import java.util.*;

public class RunningMedian{
    private MyHeap<Integer> min;
    private MyHeap<Integer> max;

    public RunningMedian(){
	min=new MyHeap<Integer>();
	max=new MyHeap<Integer>(false);
    }

    public double getMedian(){
	if(min.getSize()==0&&max.getSize()==0){
	    throw new NoSuchElementException();
	}
	if (min.getSize()==max.getSize()){
	    return (min.peek()+max.peek())/2.0;
	}else if(min.getSize()>max.getSize()){
	    return min.peek();
	}else{
	    return max.peek();
	}
    }

    public void add(Integer x){
	if(min.getSize()==0&&max.getSize()==0){
	    min.add(x);
	}else if(x>getMedian()){
	    max.add(x);
	}else{
	    min.add(x);
	}
	if(Math.abs(min.getSize()-max.getSize())>1){
	    balance();
	}
    }

    private void balance(){
	if(min.getSize()>max.getSize()){
	    max.add(min.remove());
	}else{
	    min.add(max.remove());
	}
    }

    public static void main(String[]args){
	RunningMedian t1=new RunningMedian();
	t1.add(3);
	System.out.println(t1.getMedian());
	t1.add(4);
	System.out.println(t1.getMedian());
	t1.add(5);
	System.out.println(t1.getMedian());
	t1.add(6);
	System.out.println(t1.getMedian());
	t1.add(7);
	System.out.println(t1.getMedian());
	t1.add(0);
	System.out.println(t1.getMedian());
	t1.add(2);
	System.out.println(t1.getMedian());
    }
}
