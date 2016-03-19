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

    public boolean add(int value){
	if (start==null){
	    start=new LNode(value);
	    return true;
	}
	else{
	    LNode current = start;
	    while (current.getNext()!=null){
		current=current.getNext();
	    }
	    current.setNext(new LNode(value));
	    size++;
	    return true;
	}
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
	l.add(-3);
	System.out.println(l);
    }
}
