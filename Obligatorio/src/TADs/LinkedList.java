package TADs;

public class LinkedList<T> implements List<T> {

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	public Nodo<T> primero;

	public void add(T nValue) {

		Nodo<T> oItem = new Nodo(nValue);

		if (primero == null) {

			primero = oItem;

		} else {
			Nodo<T> ultimo = primero;

			while (ultimo.getSiguiente() != null) {
				ultimo = ultimo.getSiguiente();
			}
			ultimo.setSiguiente(oItem);
		}

	}

	public int size() {
		int size = 0;
		if (primero == null) {
			size = 0;
		} else {
			size = 1;
			Nodo<T> ultimo = primero;
			while (ultimo.getSiguiente() != null) {
				ultimo = ultimo.getSiguiente();
				size++;
			}
		}

		return size;
	}

	public T get(int pos) throws PosInvalida {
		T valor = null;
		if (pos >= size()) {
			PosInvalida oError = new PosInvalida("Posición Inválida");
			System.out.println("Posicion invalida");
			throw oError;

		}

		else {
			Nodo<T> miNodo = primero;
			for (int i = 0; i < pos; i++) {
				miNodo = miNodo.getSiguiente();

			}
			valor = miNodo.getValor();
		}
		return valor;
	}

	public void delete(int pos) throws PosInvalida {
		Nodo aux = primero;

		if (size() == 1) {
			primero = null;
		} else {

			if (pos >= size()) {
				PosInvalida oError = new PosInvalida("Posición inválida");
				System.out.println("Posicion invalida");
				throw oError;
			} else {
				if (pos == 0) {
					primero = primero.getSiguiente();
				}
				for (int i = 0; i < (pos) - 1; i++) {
					aux = aux.getSiguiente();
				}
				aux.setSiguiente(aux.getSiguiente().getSiguiente());

			}
		}

	}

	public boolean isOnList(T valor) {

		boolean resultado = false;
		Nodo<T> ultimo = primero;

		while (ultimo != null && ultimo.getValor() != valor) {

			ultimo = ultimo.getSiguiente();

		}
		if (ultimo != null && ultimo.getValor() == valor) {
			resultado = true;
		}

		return resultado;

	}

	public void addFirst(T valor) {
		Nodo<T> oItem = new Nodo(valor);

		oItem.setSiguiente(primero);
		primero = oItem;

	}

}
