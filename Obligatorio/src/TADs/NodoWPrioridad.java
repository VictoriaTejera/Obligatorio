package TADs;

public class NodoWPrioridad<T> {
	private T valor;
	private NodoWPrioridad siguiente;
	
	private int prioridad;
	
	
	public NodoWPrioridad(T valor, int prioridad) {
		this.valor= valor;
		siguiente=null;
		this.prioridad=prioridad;
	}
	
	

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	

	public T getValor() {
		return valor;
	}




	public void setValor(T valor) {
		this.valor = valor;
	}

	public NodoWPrioridad getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoWPrioridad siguiente) {
		this.siguiente = siguiente;
	}
	

	

}


