package uy.edu.um.prog2.adt.Queue;

public interface MyPriotityQueue<T> extends MyQueue<T> {

	public void insert(T elemento,int prioridad);
	int size();
}
