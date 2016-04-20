public class BSTree<T extends comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	private void setLeft(Node newL){
	    left=newL;
	}
	private Node getLeft(){
	    return left;
	}
	private void setRight(Node newR){
	    right=newR;
	}
	private Node getRight(){
	    return right;
	}
	private void setData(T newD){
	    data=newD;
	}
	private T getData(){
	    return data;
	}

	public void add(T value, Node current){
	    if(value.compareTo(current.getData())<0){
		if(current.getLeft()==null){
		    current.setLeft(value);
		}
		else{
		    add(value,current.getLeft());
		}
	    }else{
		if(current.getLeft()==null){
		    current.setRight(value);
		}
		else{
		    add(value,current.getRight());
		}
	    }
	}
	public String toString(){
	    
	}
	public boolean contains(T value){
	    
	}
	public int getHeight(){
	    
	}
    }

}
