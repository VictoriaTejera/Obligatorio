package TADs;

public interface MyPriotityQueue<T> extends MyQueue<T> {

	public void insert(T elemento,int prioridad);
	int size();
}
