public class MyDeque<T>{
    private Object[] deque;
    private int start;
    private int end;
    private int size;

    public MyDeque(){
	deque=new Object[10];
    }

    private void grow(){
	Object[] temp=new Object[size*2];
	for(int ctr=0;ctr<size;ctr++){
	    temp[ctr]=deque[(ctr+start)%size];
	}
	start=0;
	end=size-1;
    }

    public void addFirst(T value){
	if (start-1<0){
	    start=deque.length-1;
	}
	start--;
	if(start==end){
	    grow();
	}
	deque[start]=value;
	size++;
    }

    public void addLast(T value){
	
    }

}
