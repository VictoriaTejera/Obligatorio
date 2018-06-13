package uy.edu.um.prog2.adt.Hash;

import static java.lang.Math.abs;

import java.util.Iterator;

import uy.edu.um.prog2.adt.Iterator.MyIterator;



public class HashCerrado<K, T> implements HashTable<K, T> {
	private NodoHash<K, T>[] vector;
	private int size;
	private int cantElementos;
	private boolean resolucionLineal;
	

	public HashCerrado(int sizeInicial, boolean resolucionLineal) {
		vector = new NodoHash[sizeInicial];
		size = sizeInicial;
		cantElementos = 0;
		this.resolucionLineal = resolucionLineal;
	}

	public void insertar(K clave, T valor) throws ElementoYaExistenteException {
		NodoHash<K, T> nuevoNodo = new NodoHash<>(clave, valor);
		
		
		
		if ((float) cantElementos / size > 0.8) {
			agrandarHash();
		}
		int posicion = abs(clave.hashCode() % size);
		if (vector[posicion] == null || vector[posicion].isEliminado()) {
			vector[posicion] = nuevoNodo;
		} else {
			int posAux = posicion;
			int cuadratica = 1;
			while (vector[posAux] != null && !vector[posAux].isEliminado()) {
				if (resolucionLineal) {
					posAux++;
					if (posAux >= size) {
						posAux = 0;
					}
				} else {
					posAux = posAux + cuadratica * cuadratica;
					cuadratica++;
					while (posAux >= size) {
						posAux = posAux - size;
					}
				}
			}
			vector[posAux] = nuevoNodo;
		}
		cantElementos++;
	}

	public boolean pertenece(K clave) {
		boolean pertenece = false;
		int posEsperada = abs(clave.hashCode() % size);
		if (vector[posEsperada] != null) {
			if (vector[posEsperada].getClave().equals(clave) && vector[posEsperada].isEliminado() == false) {
				pertenece = true;
			} else {
				if (resolucionLineal) {
					posEsperada++;
					if(posEsperada==size) {
						posEsperada=0;
					}
					int cantRecorridas = 0;
					while (cantRecorridas < size
							&& (vector[posEsperada] != null && !vector[posEsperada].getClave().equals(clave))) {
						posEsperada++;
						if(posEsperada==size) {
							posEsperada=0;
						}
						
						cantRecorridas++;
					}
				} else {
					int cuadratica = 1;
					while (vector[posEsperada] != null && !vector[posEsperada].getClave().equals(clave)) {
						posEsperada = posEsperada + cuadratica * cuadratica;
						cuadratica++;
						while (posEsperada >= size) {
							posEsperada = posEsperada - size;
						}
					}
				}
				if (posEsperada < vector.length && vector[posEsperada] != null) {
					if (vector[posEsperada].getClave().equals(clave) && vector[posEsperada].isEliminado() == false) {
						pertenece = true;
					}
				}
			}
		}
		return pertenece;
	}

	public void borrar(K clave) throws ClaveInvalida {
		if (pertenece(clave)) {
			get(clave).setEliminado(true);
			cantElementos--;
		} else {
			throw new ClaveInvalida();
		}
	}

	private void agrandarHash() {
		int nuevoSize = 2 * size;
		NodoHash<K, T>[] vectorNuevo = new NodoHash[nuevoSize];
		for (int i = 0; i < size; i++) {

			if (vector[i] != null) {
				K claveAux = vector[i].getClave();
				T valorAux = vector[i].getValor();

				int posicion = abs(claveAux.hashCode() % nuevoSize);
				if (vectorNuevo[posicion] == null) {
					vectorNuevo[posicion] = vector[i];
				} else {
					int posAux = posicion;
					int cuadratica = 1;
					while (vectorNuevo[posAux] != null && vectorNuevo[posAux].isEliminado()) {
						if (resolucionLineal) {
							posAux++;
							if (posAux >= size) {
								posAux = 0;
							}
						} else {
							posAux = posAux + cuadratica * cuadratica;
							cuadratica++;
							while (posAux >= size) {
								posAux = posAux - size;
							}
						}
					}
					vectorNuevo[posAux] = vector[i];
				}
			}
		}
		size = nuevoSize;
		vector = vectorNuevo;

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private NodoHash<K, T> get(K clave) {
		NodoHash<K, T> nodo = null;
		int posEsperada = clave.hashCode() % size;
		if (vector[posEsperada].getClave().equals(clave) && vector[posEsperada].isEliminado() == false) {
			nodo = vector[posEsperada];
		} else {
			if (resolucionLineal) {
				posEsperada++;
				while (posEsperada < vector.length
						&& (vector[posEsperada] != null && !vector[posEsperada].getClave().equals(clave))) {
					posEsperada++;
				}
			} else {
				int cuadratica = 1;
				while (posEsperada < vector.length
						&& (vector[posEsperada] != null && !vector[posEsperada].getClave().equals(clave))) {
					posEsperada = posEsperada + cuadratica * cuadratica;
					while (posEsperada >= size) {
						posEsperada = posEsperada - size;
					}
				}
			}
			if (vector[posEsperada].getClave().equals(clave) && vector[posEsperada].isEliminado() == false) {
				nodo = vector[posEsperada];
			}
		}
		return nodo;
	}
	
	public T obtener(K key) {
		T valor = null;
		int posEsperada = abs(key.hashCode() % size);
		if (vector[posEsperada] != null) {
			if (vector[posEsperada].getClave().equals(key) && vector[posEsperada].isEliminado() == false) {
				valor = vector[posEsperada].getValor();
			} else {
				if (resolucionLineal) {
					posEsperada++;
					if (posEsperada >= size) {
						posEsperada = 0;
					}
					int cantRecorridas = 0;
					while (cantRecorridas < size
							&& (vector[posEsperada] != null && !vector[posEsperada].getClave().equals(key))) {
						posEsperada++;
						if (posEsperada >= size) {
							posEsperada = 0;
						}
						cantRecorridas++;
					}
				} else {
					int cuadratica = 1;
					while (vector[posEsperada] != null && !vector[posEsperada].getClave().equals(key)) {
						posEsperada = posEsperada + cuadratica * cuadratica;
						cuadratica++;
						while (posEsperada >= size) {
							posEsperada = posEsperada - size;
						}
					}
				}
				if (posEsperada < vector.length && vector[posEsperada] != null) {
					if (vector[posEsperada].getClave().equals(key) && vector[posEsperada].isEliminado() == false) {
						valor = vector[posEsperada].getValor();
					}
				}
			}
		}
		return valor;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new MyIterator<K,T>(vector);
	}

	@Override
	public int size() {
		
		return size;
	}

	


}
