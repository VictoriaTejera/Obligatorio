package TADs;


public class Nodo<T> {

	private T valor;
	private Nodo siguiente;
	private Nodo anterior;
	



	public Nodo getAnterior() {
		return anterior;
	}




	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}




	public T getValor() {
		return valor;
	}




	public void setValor(T valor) {
		this.valor = valor;
	}




	public Nodo(T nValor) {
		valor= nValor;
		siguiente=null;
		
		
	}
	
	
	

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}




	public Nodo getSiguiente() {
		return siguiente;
	}

}



