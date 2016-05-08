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
	for(int i=size;i>0;i--){
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
	for(int i=size;i>0;i--){
	    pushDown(i);
	}
    }
    
    public T remove(){
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
	try{
	    if(heap[pos*2+1]==null||compare(heap[pos*2],heap[pos*2+1])){
		T temp=heap[pos*2];
		heap[pos*2]=heap[pos];
		heap[pos]=temp;
		if (pos*2<=size){
		    pushDown(pos*2);
		}
	    }else{
		T temp=heap[pos*2+1];
		heap[pos*2+1]=heap[pos];
		heap[pos]=temp;
		if (pos*2+1<=size){
		    pushDown(pos*2+1);
		}
	    }
	}catch(IndexOutOfBoundsException e){
	}
    }

    public T peek(){
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
    
}
