package TADs;

public interface MyStack<T> {
	
	public void pop () throws EmptyStackException;//borrar
	 public T top() throws EmptyStackException; //get
	 public void push(T element); //agregar
	 public boolean isEmpty ();
	 public void makeEmpty();
}
