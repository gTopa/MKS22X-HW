public class MyLinkedList{
    private class LNode{
	private int value;
	private LNode next;
	
	public LNode(int val){
	    value=val;
	}
	public void setNext(LNode nxt){
	    next=nxt;
	}
	public LNode getNext(){
	    return next;
	}
	public void setValue(int val){
	    value=val;
	}
	public int getValue(){
	    return value;
	}
    }
    private int size;
    private LNode start;
    private LNode end;
    
    public boolean add(int value){
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
    
    public boolean add(int value, int pos){
	if(pos>size){
	    return false;
	}else if(pos==0){
	    LNode current = start;
	    start=new LNode(value);
	    start.setNext(current);
	    end=start;
	    return true;
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
	if(pos>size){
	    return false;
	}else if(pos==0){
	    start=start.getNext();
	    return true;
	}else{
	    LNode current = start;
	    for (int i=0;i<pos-1;i++){
		current=current.getNext();
	    }
	    current.setNext(current.getNext().getNext());
	    size--;
	    return true;
	}
    }

    public int get(int pos){
	if(pos>=size){
	    System.out.println("Index out of Bounds");
	}
	LNode current=start;
	for (int i=0;i<pos;i++){
	    current=current.getNext();
	}
	return current.getValue();
    }

    public int set(int value, int pos){
	if(pos>=size){
	    System.out.println("Index out of Bounds");
	}
	LNode current=start;
	for (int i=0;i<pos;i++){
	    current=current.getNext();
	}
	int temp=current.getValue();
	current.setValue(value);
	return temp;
    }
    
    public int size(){
	return size;
    }

    public int indexOf(int value){
	int pos=0;
	LNode current=start;
	while(current.getNext()!=null){
	    if (current.getValue()==value){
		return pos;
	    }
	    current=current.getNext();
	}
	return -1;
    }
    
    public String toString(){
	String ans="[";
	LNode current = start;
	while(current!=null){
	    ans+=current.getValue();
	    if(current.getNext()!=null){
		ans+=", ";
	    }
	    current=current.getNext();
	}
	return ans+"]";
    }

    public static void main(String[]args){
	MyLinkedList l=new MyLinkedList();
	l.add(3);
	System.out.println(l);
	l.add(-3,1);
	System.out.println(l);
	l.add(-3);
	System.out.println(l);
	l.remove(1);
	System.out.println(l);
	System.out.println(l.get(1));	
	System.out.println(l.set(3,1));	
	System.out.println(l);
	System.out.println(l.indexOf(3));
	System.out.println(l.indexOf(2));
    }
}
