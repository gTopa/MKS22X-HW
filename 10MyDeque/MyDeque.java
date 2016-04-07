public class MyDeque<T>{
    private T[] deque;
    private int start;
    private int end;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	deque=(T[]) new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    private void grow(){
	T[] temp=(T[]) new Object[size*2];
	for(int ctr=0;ctr<size;ctr++){
	    temp[ctr]=deque[(ctr+start)%size];
	}
	start=0;
	end=size-1;
    }
    
    public void addFirst(T value){
	if(size==1){
	    if (start-1<0){
		start=deque.length;
	    }
	    start--;
	    deque[start]=value;
	    size++;
	}else if (start==end){
	    deque[start]=value;
	    size++;
	}else{
	    if (start-1<0){
		start=deque.length;
	    }
	    start--;
	    if(start==end){
		grow();
	    }
	    deque[start]=value;
	    size++;
	}
    }

    public void addLast(T value){
	if(size==1){
	    if(end+1>=deque.length){
		end=-1;
	    }
	    end++;
	    deque[end]=value;
	    size++;
	}else if (start==end){
	    deque[start]=value;
	    size++;
	}else{
	    if(end+1>=deque.length){
		end=-1;
	    }
	    end++;
	    if (start==end){
		grow();
	    }
	    deque[end]=value;
	    size++;
	}
    }

    public T removeFirst(){
	T temp=deque[start];
	if(start+1>=deque.length){
	    start=-1;
	}
	start++;
	size--;
	return temp;	
    }

    public T removeLast(){
	T temp=deque[end];
	if (end-1<0){
	    end=deque.length;
	}
	end--;
	size--;
	return temp;
    }

    public T getFirst(){
	return deque[start];
    }

    public T getLast(){
	return deque[end];
    }

    public String toString(){
	String retr="";
	for(int i=0;i<deque.length;i++){
	    retr+=deque[(start+i)%deque.length];
	}
	return retr;
    }
}
