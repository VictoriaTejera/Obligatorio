package TADs;

public interface MyQueue<T> {
	public void enqueue(T element);
	public void dequeue() throws EmptyQueueException; 
	public boolean isEmpty(); 
	public T getFirst() throws EmptyQueueException;

}
