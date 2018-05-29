package uy.edu.um.prog2.adt.Stack;

import uy.edu.um.prog2.adt.Lista.Nodo;



public class Stack<T> implements MyStack<T> {

	public Nodo<T> primero;

	public void pop() throws EmptyStackException {
		Nodo<T> ultimo = primero;
		if (primero.getSiguiente() == null) {
			primero = null;
		}else {
		while (ultimo.getSiguiente().getSiguiente() != null) {
			ultimo = ultimo.getSiguiente();
		}
		ultimo.setSiguiente(null);
		}
	}

	public void push(T nValue) {
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

	public boolean isEmpty() {
		boolean resultado = false;
		if (primero == null) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado;

	}

	public void makeEmpty() {
		while (primero != null) {
			try {
				pop();
			} catch (EmptyStackException e) {

			}
		}

	}

	public T top() throws EmptyStackException {
		T elemento = null;
		Nodo<T> ultimo = primero;
		while (ultimo.getSiguiente() != null) {
			ultimo = ultimo.getSiguiente();

		}
		elemento = ultimo.getValor();
		return elemento;
	}

}
// Debug pruebo en tiempo de implementación