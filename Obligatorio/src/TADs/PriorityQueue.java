package TADs;

public class PriorityQueue<T> implements MyPriotityQueue<T> {
	
	NodoWPrioridad<T>primero;

	public void enqueue(T valor) {
		
		insert(valor,0);
	}

	
	public void dequeue() throws EmptyQueueException {
		primero=primero.getSiguiente();
		
	}

	
	public boolean isEmpty() {
		boolean resultado=false;
		if(primero==null) {
			resultado=true;
		}
		return resultado;
	}

	
	public T getFirst() throws EmptyQueueException {
		T first;
		if(primero==null) {
			throw new EmptyQueueException();
		}else {
		first= primero.getValor();}
		return first;
	}


	
	public void insert(T valor, int prioridad) {
		NodoWPrioridad<T> oItem= new NodoWPrioridad<T>(valor, prioridad);
		NodoWPrioridad<T> ultimo=primero;
		
		if(primero==null) {
			primero=oItem;
		}
		else if(primero.getSiguiente()==null) {
			if(primero.getPrioridad()>=oItem.getPrioridad()) {
				primero.setSiguiente(oItem);
			}else {
				oItem.setSiguiente(primero);
				primero=oItem;
			}
		}else {
		try {
		while(ultimo.getSiguiente().getPrioridad()>= oItem.getPrioridad()) {
			ultimo=ultimo.getSiguiente();
		}
		oItem.setSiguiente(ultimo.getSiguiente());
		ultimo.setSiguiente(oItem);
		}catch(NullPointerException e){
			NodoWPrioridad<T>ultimoP=primero;
			while(ultimoP.getSiguiente()!=null) {
				ultimoP=ultimoP.getSiguiente();
			}
			ultimoP.setSiguiente(oItem);
			
			
		}
		}
		}


	
	public int size() {
		int size=0;
		if(primero==null) {
			size=0;
		}
		else {
			size=1;
			NodoWPrioridad<T> ultimo= primero;
			while(ultimo.getSiguiente()!=null) {
				ultimo=ultimo.getSiguiente();
				size++;
			}
		}
		
		
		return size;
	}

	

}




	


	