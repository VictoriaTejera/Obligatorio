package uy.edu.um.prog2.adt.SearchTree;

import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;
import uy.edu.um.prog2.adt.Lista.PosInvalida;

public class BinaryTree<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T> {

	private NodeBST<K, T> root;

	public T find(K key) {
		T elementData = null;
		if (root != null) {
			NodeBST<K, T> aux = root;
			while (aux != null) {
				if (key.compareTo(aux.getKey()) < 0) {
					aux = aux.getLeftChild();
				} else if (key.compareTo(aux.getKey()) > 0) {
					aux = aux.getRightChild();
				} else {
					elementData = aux.getData();
					aux = null;
				}
			}
		}
		return elementData;
	}

	public void insert(K key, T data) {
		NodeBST<K, T> element = new NodeBST<K, T>(key, data);
		if (root == null) {
			root = element;
		} else {
			NodeBST<K, T> aux = root;
			int trigger = 0;
			while (trigger == 0) {
				if (element.getKey().compareTo(aux.getKey()) < 0) {
					if (aux.getLeftChild() != null) {
						aux = aux.getLeftChild();
					} else {
						trigger = -1;
					}
				} else {
					if (aux.getRightChild() != null) {
						aux = aux.getRightChild();
					} else {
						trigger = 1;
					}
				}
			}
			if (trigger == -1) {
				aux.setLeftChild(element);
			} else {
				aux.setRightChild(element);
			}
		}
	}

	public void delete(K key) throws InvalidKey {
		NodeBST<K, T> aEliminar = findNodeInAll(key);
		if(aEliminar==null) {
			throw new InvalidKey();
		}
		NodeBST<K, T> replacement = null;
		K keyAux = null;
		T dataAux = null;
		if (aEliminar.getLeftChild() != null) {
			replacement = findReplacement(aEliminar, 'l');
			keyAux = replacement.getKey();
			dataAux = replacement.getData();
			replacement.setKey(aEliminar.getKey());
			replacement.setData(aEliminar.getData());
			aEliminar.setKey(keyAux);
			aEliminar.setData(dataAux);
			delete(key);
		} else if (aEliminar.getRightChild() != null) {
			replacement = findReplacement(aEliminar, 'r');
			keyAux = replacement.getKey();
			dataAux = replacement.getData();
			replacement.setKey(aEliminar.getKey());
			replacement.setData(aEliminar.getData());
			aEliminar.setKey(keyAux);
			aEliminar.setData(dataAux);
			delete(key);
		} else {
			if (root.findPadre(key) != null) {
				if (root.findPadre(key).getLeftChild() == aEliminar) {
					root.findPadre(key).setLeftChild(null);
				} else {
					root.findPadre(key).setRightChild(null);
				}
			} else {
				root = null;
			}
		}
	}

	private NodeBST<K, T> findNodeInAll(K key) {
		NodeBST<K, T> element = null;
		if (root != null) {
			element = root.findN(key);
		}
		return element;
	}

	private NodeBST<K, T> findReplacement(NodeBST<K, T> nodo, char tipo) {
		NodeBST<K, T> replacement = null;
		boolean condDeParada;
		switch (tipo) {
		case 'l':
			replacement = nodo.getLeftChild();
			condDeParada = true;
			while (condDeParada == true) {
				if (replacement.getRightChild() != null) {
					replacement = replacement.getRightChild();
				} else {
					condDeParada = false;
				}
			}
			break;
		case 'r':
			replacement = nodo.getRightChild();
			condDeParada = true;
			while (condDeParada == true) {
				if (replacement.getLeftChild() != null) {
					replacement = replacement.getLeftChild();
				} else {
					condDeParada = false;
				}
			}
			break;
		}
		return replacement;
	}

	public List<T> inOrder() {
		List<T> lista = new LinkedList<T>();
		for (int i = 0; i < root.inOrderN().size(); i++) {
			try {
				lista.add((T) root.inOrderN().get(i));
			} catch (PosInvalida e) {
				System.out.println("error");
			}
		}
		return lista;
	}

	@Override
	public List<T> preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
