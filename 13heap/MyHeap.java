import java.util.*;
@SuppressWarnings("unchecked")
pulbic class MyHeap<T extends Comparable<T>>{
    private T[] heap;
    private boolean isMax;
    private int size;
    
    public MyHeap(){
	heap=(T)new Comparable[];
	isMax=true;
	size=0;
    }

    public MyHeap(boolean max){
	heap=(T)new Comparable[];
	isMax=max;
	size=0;
    }

    public T remove(){
	heap[1]=heap[size];
	size--;
	
    }

    public void add(T value){
	if (size+1==heap.length){
	    resize();
	}
	size++;
	heap[size]=value;
	int pos=size;
	while(pos>1&&compare(heap[pos],heap[pos/2])){
	    pushUp(pos);
	    pos=pos/2;
	}
    }

    private void pushUp(int pos){
	if(compare(heap[pos],heap[pos/2])){
	    T temp=heap[pos/2];
	    heap[pos/2]=heap[pos];
	    heap[pos]=temp;
	}
    }

    private void pushDown(int pos){
	if(compare(heap[pos*2],heap[pos*2+1])){
	    T temp=heap[pos*2];
	    heap[pos*2]=heap[pos];
	    heap[pos]=temp;
	}else{
	    T temp=heap[pos*2+1];
	    heap[pos*2+1]=heap[pos];
	    heap[pos]=temp;
	}
    }

    public T peek(){
	return heap[1];
    }
    
    public boolean compare(T first, T second){
	if(iSMax){
	    return first.compareTo(second)>0;
	}else{
	    return second.compareTo(first)>0;
	}
    }
