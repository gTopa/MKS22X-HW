public class MyQueue<T>{

    private MyLinkedList<T> l;

    public MyQueue(){
	l=new MyLinkedList<T>();
    }

     /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item){
	l.add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue(){
	return l.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	return l.get(0);
    }
    /**
     * Returns the number of items currently in the queue.
     */
    public int size(){
	return l.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty(){
	return l.size()==0;
    }
}
