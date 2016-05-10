import java.util.*;
@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>>{
    private T[] heap;
    private boolean isMax;
    private int size;
    
    public MyHeap(){
	heap=(T[])(new Comparable[10]);
	isMax=true;
	size=0;
    }

    public MyHeap(boolean max){
	heap=(T[])(new Comparable[10]);
	isMax=max;
	size=0;
    }
    
    public MyHeap(T[] array, boolean max){
	isMax=max;
	size=array.length;
	heap=(T[])new Comparable[array.length+1];
	for(int i=1;i<=size;i++){
	    heap[i]=array[i-1];
	}
	for(int i=size/2;i>0;i--){
	    pushDown(i);
	}
    }
    
    public MyHeap(T[] array){
	isMax=true;
	size=array.length;
	heap=(T[])new Comparable[array.length+1];
	for(int i=1;i<=size;i++){
	    heap[i]=array[i-1];
	}
	for(int i=size/2;i>0;i--){
	    pushDown(i);
	}
    }
    
    public T remove(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	T temp=heap[1];
	heap[1]=heap[size];
	size--;
	pushDown(1);
	return temp;
    }

    public void add(T value){
	if (size+1==heap.length){
	    resize();
	}
	size++;
	heap[size]=value;
	pushUp(size);
    }

    private void resize(){
	T[] temp=(T[])new Comparable[size*2+1];
	for (int i=1;i<=size;i++){
	    temp[i]=heap[i];
	}
	heap=temp;
    }

    private void pushUp(int pos){
	if(pos>1&&compare(heap[pos],heap[pos/2])){
	    T temp=heap[pos/2];
	    heap[pos/2]=heap[pos];
	    heap[pos]=temp;
	    pushUp(pos/2);
	}
    }

    private void pushDown(int pos){
	if(pos*2+1<=size){
	    if(compare(heap[pos*2],heap[pos*2+1])){
		if(compare(heap[pos*2],heap[pos])){
		    T temp=heap[pos*2];
		    heap[pos*2]=heap[pos];
		    heap[pos]=temp;
		    pushDown(pos*2);
		}
	    }else{
		if(compare(heap[pos*2+1],heap[pos])){
		    T temp=heap[pos*2+1];
		    heap[pos*2+1]=heap[pos];
		    heap[pos]=temp;
		    pushDown(pos*2+1);
		}
	    }
	}else{
	    if(pos*2==size){
		if(compare(heap[pos*2],heap[pos])){
		    T temp=heap[pos*2];
		    heap[pos*2]=heap[pos];
		    heap[pos]=temp;
		}
	    }
	}
    }

    public T peek(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return heap[1];
    }
    
    public boolean compare(T first, T second){
	if(isMax){
	    return first.compareTo(second)>0;
	}else{
	    return second.compareTo(first)>0;
	}
    }

    public String toString(){
	String temp="";
	for (int i=1;i<=size;i++){
	    temp+=heap[i]+" ";
	}
	return temp;
	//return Arrays.toString(heap);
    }

    public int getSize(){
	return size;
    }
    
    public static void main(String[]args){
	MyHeap<Integer> t1=new MyHeap<Integer>();
	t1.add(1);
	t1.add(3);
	t1.add(-12);
	t1.add(31);
	t1.add(13);
	t1.remove();
	t1.remove();
	t1.remove();
	System.out.println(t1);
    }
}
