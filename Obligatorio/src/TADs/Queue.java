package TADs;



public class Queue<T> implements MyQueue<T> {

	LinkedList<T> lista = new LinkedList<T>();
	
	
	public void enqueue(T nValue) {
		lista.add(nValue);
		
		
	}

	
	public void dequeue() throws EmptyQueueException {
		try {
		lista.delete(0);
		}catch(PosInvalida e) {
			System.out.println("La cola est� vacia");
		}
		}
	

	
	public boolean isEmpty() {
		boolean resultado=false;
		try {
		 lista.get(0);
		 }
		catch(PosInvalida e) {
		resultado=true;
		}
		return resultado;
	}

	
	public T getFirst() throws EmptyQueueException {
	T valor=null;
		try {
	 valor= lista.get(0);
	  
	}
		catch(PosInvalida e) {
			System.out.println("La cola est� vac�a");
		}
		return valor;
	}
	
	public int size() {
		int size=0;
		size=lista.size();
		return size;
	}


	

}
