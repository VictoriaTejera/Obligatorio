package uy.edu.um.prog2.adt.Heap;

public class HeapImpl<P extends Comparable<P>, T> implements MyHeap<P, T> {

	private NodoHeap<P, T>[] elements;
	private int size = 0;
	private int tipoArbol;

	public HeapImpl(int size, int tipoArbol) {
		elements = new NodoHeap[size];
		if (tipoArbol == -1 || tipoArbol == 1) {
			this.tipoArbol = tipoArbol;
		} else {
			System.out.println("Ingrese un valor válido: 1 o -1");
		}
	}
	private NodoHeap getParent(int nPos) {
		NodoHeap<P,T> oResult = null;

		if (nPos > 0) {
			int nPosParent = getPosParent(nPos);
			oResult = elements[nPosParent];
		}
		return oResult;
	}

	private int getPosParent(int nPos) {
		int nValue = 0;
		if (nPos > 0) {
			nValue = (nPos - 1) / 2;
		}
		return nValue;
	}
	

	public int getPosLeftChild(int pos) {
		int posChild = 2 * pos + 1;
		if (posChild > size - 1) {
			posChild = 0;
		}

		return posChild;
	}

	public int getPosRightChild(int pos) {
		int posChild = 2 * pos + 2;
		if (posChild > size - 1) {
			posChild = 0;
		}

		return posChild;
	}

	public NodoHeap getLeftChild(int pos) {
		NodoHeap<P, T> leftChild = null;
		if(getPosLeftChild(pos)!=0) {
			leftChild=	elements[getPosLeftChild(pos)];
		}
		return leftChild;
	}

	public NodoHeap getRightChild(int pos) {
		NodoHeap<P, T> rightChild=null;
		if(getPosRightChild(pos)!=0) {
			rightChild=	 elements[getPosRightChild(pos)];
		}
		return rightChild;
	}

	 

	public NodoHeap<P, T>[] getElements() {
		return elements;
	}


	public void insert(P priority, T data) {

		int nPosActual = size;
		NodoHeap<P, T> nuevoNodo = new NodoHeap<>(priority, data);
		elements[size] = nuevoNodo; //agrego el nodo al primer lugar vacío
		if (tipoArbol == 1) {
			while (getParent(nPosActual) != null
					&& getParent(nPosActual).getPriority().compareTo(nuevoNodo.getPriority()) < 0)//Arbol para el mayor en la raíz
			{
				NodoHeap<P, T> padre = elements[getPosParent(nPosActual)];

				elements[getPosParent(nPosActual)] = nuevoNodo; //el nuevo nodo pasa a la posición del padre
				elements[nPosActual] = padre;// el padre baja una posición 
				nPosActual = getPosParent(nPosActual);
			}
		} else {
			while (getParent(nPosActual) != null
					&& getParent(nPosActual).getPriority().compareTo(nuevoNodo.getPriority()) > 0) //Arbol para el menor en la raíz
			{
				NodoHeap<P, T> padre = elements[getPosParent(nPosActual)];

				elements[getPosParent(nPosActual)] = nuevoNodo;
				elements[nPosActual] = padre;
				nPosActual = getPosParent(nPosActual);
			}

		}

		size++;

	}

	
	public  T findAndDelete()  throws HeapVacio {
		NodoHeap<P,T> datoEliminado=elements[0];
		if(this.getSize()==0) {
			throw new HeapVacio();
		}
		if(this.getSize()==1) {
			elements[0]=null;
			size=0;
		}else {
		elements[0] = elements[size - 1];  //Paso el ultimo elemento a la primera posición
		elements[size - 1] = null; //borro el ultimo lugar
		size--;
		int posActual = 0;
		NodoHeap<P, T> padre = elements[posActual];
		
		if (tipoArbol == 1) {
			while (  getLeftChild(posActual)!=null && padre.getPriority().compareTo((P) getLeftChild(posActual).getPriority()) < 0
					||getRightChild(posActual)!=null && padre.getPriority().compareTo((P) getRightChild(posActual).getPriority()) < 0 ) {

				if(getRightChild(posActual)!=null && getLeftChild(posActual)!=null) {
				if (getRightChild(posActual).getPriority().compareTo(getLeftChild(posActual).getPriority()) < 0) {
					elements[posActual] = getLeftChild(posActual);
					elements[getPosLeftChild(posActual)] = padre;
					posActual = getPosLeftChild(posActual);
					padre = elements[posActual];
				} else {
					elements[posActual] = getRightChild(posActual);
					elements[getPosRightChild(posActual)] = padre;
					posActual = getPosRightChild(posActual);
					padre = elements[posActual];
				}
				}
				else {
					if(getRightChild(posActual)!=null) {
						elements[posActual] = getLeftChild(posActual);
						elements[getPosLeftChild(posActual)] = padre;
						posActual = getPosLeftChild(posActual);
						padre = elements[posActual];
					}
					else {
						elements[posActual] = getRightChild(posActual);
						elements[getPosRightChild(posActual)] = padre;
						posActual = getPosRightChild(posActual);
						padre = elements[posActual];
					}
				}
			}
		}else {
			while (getLeftChild(posActual)!=null && padre.getPriority().compareTo((P) getLeftChild(posActual).getPriority()) >0
					||getRightChild(posActual)!=null && padre.getPriority().compareTo((P) getRightChild(posActual).getPriority()) > 0) {
				if(getRightChild(posActual)!=null && getLeftChild(posActual)!=null) {
					
				if (getRightChild(posActual).getPriority().compareTo(getLeftChild(posActual).getPriority()) > 0) {
					elements[posActual] = getLeftChild(posActual);
					elements[getPosLeftChild(posActual)] = padre;
					posActual = getPosLeftChild(posActual);
					padre = elements[posActual];
				} else {
					elements[posActual] = getRightChild(posActual);
					elements[getPosRightChild(posActual)] = padre;
					posActual = getPosRightChild(posActual);
					padre = elements[posActual];
				}
			}
				else {
					if(getRightChild(posActual)!=null) {
						elements[posActual] = getRightChild(posActual);
						elements[getPosRightChild(posActual)] = padre;
						posActual = getPosRightChild(posActual);
						padre = elements[posActual];
					}
					else {
						elements[posActual] = getLeftChild(posActual);
						elements[getPosLeftChild(posActual)] = padre;
						posActual = getPosLeftChild(posActual);
						padre = elements[posActual];
					}
				}
			}		
		}
		}
		
		return datoEliminado.getData();
	}
	public T get() {
		 
		T valor=null;
		if(size!=0) {
		valor=elements[0].getData();
		}
		return valor;
	}

	public int getSize() {
		int size = 0;
		
		for(int i = 0; i < this.size; i++) {
			if(elements[i] != null) {
				size++;
			}
		}
		return size;
	}
	

}

