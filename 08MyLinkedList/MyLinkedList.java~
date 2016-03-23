public class MyLinkedList<T>{
    private class LNode{
	private T value;
	private LNode next;
	
	public LNode(T val){
	    value=val;
	}
	public void setNext(LNode nxt){
	    next=nxt;
	}
	public LNode getNext(){
	    return next;
	}
	public void setValue(T val){
	    value=val;
	}
	public T getValue(){
	    return value;
	}
    }
    private int size;
    private LNode start;
    private LNode end;
    
    public boolean add(T value){
	if (start==null){
	    start=new LNode(value);
	    size++;
	    end=start;
	    return true;
	}else{
	    end.setNext(new LNode(value));
	    end=end.getNext();
	    size++;
	    return true;
	}
    }
    
    public boolean add(int pos, T value){
	if(pos>size||pos<0){
	    throw new IndexOutOfBoundsException();
	}else if(pos==0){
	    LNode current = start;
	    start=new LNode(value);
	    start.setNext(current);
	    return true;
	}else if(pos==size){
	    return add(value);
	}else{
	    LNode current = start;
	    for (int i=0;i<pos-1;i++){
		current=current.getNext();
	    }
	    LNode n=new LNode(value);
	    n.setNext(current.getNext());
	    current.setNext(n);
	    size++;
	    if(pos==size-1){
		end=current.getNext();
	    }
	    return true;
	}
    }

    public boolean remove(int pos){
	if(pos>=size||pos<0){
	    throw new IndexOutOfBoundsException();
	}else if(pos==0){
	    start=start.getNext();
	    size--;
	    return true;
	}else{
	    LNode current = start;
	    for (int i=0;i<pos-1;i++){
		current=current.getNext();
	    }
	    current.setNext(current.getNext().getNext());
	    if(pos==size-1){
		end=current;
	    }
	    size--;
	    return true;
	}
    }

    public T get(int pos){
	if(pos>=size||pos<0){
	    System.out.println("Index out of Bounds");
	}
	LNode current=start;
	for (int i=0;i<pos;i++){
	    current=current.getNext();
	}
	return current.getValue();
    }

    public T set(int pos, T value){
	if(pos>=size||pos<0){
	    throw new IndexOutOfBoundsException();
	}
	LNode current=start;
	for (int i=0;i<pos;i++){
	    current=current.getNext();
	}
	T temp=current.getValue();
	current.setValue(value);
	return temp;
    }
    
    public int size(){
	return size;
    }

    public int indexOf(T value){
	int pos=0;
	LNode current=start;
	while(current.getNext()!=null){
	    if (current.getValue().equals(value)){
		return pos;
	    }
	    current=current.getNext();
	}
	return -1;
    }
    
    public String toString(boolean debug){
	String ans="[";
	LNode current = start;
	while(current!=null){
	    ans+=current.getValue();
	    if(current.getNext()!=null){
		ans+=", ";
	    }
	    current=current.getNext();
	}
	ans+="]";
	if(debug){
	    return ans+" HEAD: "+start.getValue()+" TAIL: "+end.getValue();
	}else {
	    return ans;
	}
    }
}
