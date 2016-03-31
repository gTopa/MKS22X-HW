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
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
	return l.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
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
        public static void main(String[]args){
	MyQueue<String> a=new MyQueue<String>();
        Queue<String> b = new Queue<String>();

        //test remove random items:
        Random rand = new Random(0);
        for(int i = 0; i < 6000; i++){
            int op = rand.nextInt(4);
            if(op == 0 || a.size()==0){//ensure never empty
                a.push(""+i);
                b.push(""+i);
            }else if(op == 1 ){
                a.push(""+i);
                b.push(""+i);
            }else{
                if(!a.pop().equals(b.pop())){
                    System.out.println("Non matching elements removed\n");
		    System.exit(1);
                }
            }
        }
	System.out.println("YAY");
    }

}
