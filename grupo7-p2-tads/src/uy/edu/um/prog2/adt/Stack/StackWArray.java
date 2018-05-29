package uy.edu.um.prog2.adt.Stack;

public class StackWArray<T> implements MyStack<T> {

	private T[] lista;
	private int size = 0;

	public StackWArray(int size) {
		lista = (T[]) new Object[size];

	}
	
	

	public void pop() throws EmptyStackException {
		if (size == 0) {
			throw new EmptyStackException();
		}
		lista[size - 1] = null;
		size--;
	}

	public T top() throws EmptyStackException {
		T elemento = null;
		if (size == 0) {
			throw new EmptyStackException();
		}
		elemento = lista[size - 1];
		return elemento;
	}

	public void push(T element) {
		lista[size] = element;
		size++;

	}

	public boolean isEmpty() {
		boolean empty = false;
		if (lista[0] == null) {
			empty = true;
		}
		return empty;
	}

	public void makeEmpty() {

		for(int i=0; i<size; i++) {
			lista[i]=null;
		}
		size=0;
	}

}
