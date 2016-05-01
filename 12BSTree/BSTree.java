import java.util.*;

public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	public Node(T value){
	    data=value;
	}
	public Node(T value, Node left, Node right){
	    data=value;
	    this.left=left;
	    this.right=right;
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

	public void add(T value){
	    if(value.compareTo(data)<0){
		if(left==null){
		    left=new Node(value);
		}
		else{
		    left.add(value);
		}
	    }else{
		if(right==null){
		    right=new Node(value);
		}
		else{
		    right.add(value);
		}
	    }
	}
	public String toString(){
	    if(left== null && right == null){
		return data+" _ _";
	    }else if(left == null){
		return data+" _ "+right;
	    }else if(right==null){
		return data+" "+left+" _ ";
	    }else{
		return ""+data+" "+left+" "+right;
	    }
	}
	public boolean contains(T value){
	    if(this==null){
		return false;
	    }else if(data.compareTo(value)==0){
		return true;
	    }else if(data.compareTo(value)<0){
		return left.contains(value);
	    }else{
		return right.contains(value);
	    }
	}
	public int getHeight(Node current){
	    if (current==null){
		return 0;
	    }else{
		return 1+Math.max(getHeight(current.getLeft()),getHeight(current.getRight()));
	    }
	}

	public void remove(T value){
	    
	}
    }

    }

    private Node root;

    public void add(T value){
	if(root==null){
	    root=new Node(value);
	}else{
	    root.add(value);
	}
    }
    public String toString(){
	return root.toString();
    }

    public boolean contains(T value){
	return root.contains(value);
    }

    public int getHeight(){
	return root.getHeight();
    }

    public void remove(T value){
	if (root.contains(value)){
	    if(data.compareTo(value)==0){
		if (left==null){
		    data=right.remove(right.min());
		}else{
		    data=left.remove(left.mac());
		}
	    }else if(data.compareTo(value)<0){
		
	}
    }
    
    public static void main(String[]args){
	BSTree<Integer> twee=new BSTree<Integer>();
	twee.add(3);
	twee.add(5);
	twee.add(-1);
	twee.add(24);
	twee.add(13);
	twee.add(9);
	twee.add(12);
	twee.add(54);
	twee.add(66);
	twee.add(-45);
	twee.add(6);
	System.out.println(twee.toString());
    }
}
