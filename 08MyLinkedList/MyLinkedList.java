public class MyLinkedList{
    private int size;
    private LNode start;
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
    public MyLinkedList(){
	size=0;
    }

    public void add(int value){
	LNode current = start;
	while (current.getNext()!=null){
	    current=current.getNext();
	}
	if (current.getValue()=null){
	    current.setValue(value);
	}else{
	    current.setNext(new LNode(value));
	    size++;
	}
    }

    public String toString(){
	for (int i=0;i<size
