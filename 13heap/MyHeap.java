import java.util.*;
@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>>{
    private T[] heap;
    private boolean isMax;
    private int size;
    
    public MyHeap(){
	heap=(T)new Comparable[10];
	isMax=true;
	size=0;
    }

    public MyHeap(boolean max){
	heap=(T)new Comparable[10];
	isMax=max;
	size=0;
    }

    public T remove(){
	pushDown(1);
	size--;
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
	if(compare(heap[pos*2],heap[pos*2+1])){
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
}
