import java.util.*;

public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	public Node(T value){
	    data=value;
	}

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
		    current.setLeft(new Node(value));
		}
		else{
		    add(value,current.getLeft());
		}
	    }else{
		if(current.getLeft()==null){
		    current.setRight(new Node(value));
		}
		else{
		    add(value,current.getRight());
		}
	    }
	}
	public String toString(Node current){
	    if(current.getLeft()==null&&current.getRight()==null){
		return current.getData()+" _ _";
	    }else if(current.getRight()==null){
		return current.getData()+" "+toString(current.getLeft())+" _";
	    }else if(current.getLeft()==null){
		return current.getData()+" _ "+toString(current.getLeft());
	    }else{
		return current.getData()+toString(current.getLeft())+toString(current.getRight());
	    }
	}
	public boolean contains(T value, Node current){
	    if(current==null){
		return false;
	    }else if(current.getValue().comareTo(value)==0){
		return true;
	    }else if(current.getValue().comareTo(value)<0){
		return contains(value,current.getLeft());
	    }else{
		return contains(value,current.getRight());
	    }
	}
	public int getHeight(Node current){
	    if (current==null){
		return 0;
	    }else{
		return 1+Math.max(getheight(current.getLeft()),getHeight(current.getRight()));
	    }
	}
    }

}
