package uy.edu.um.prog2.adt.SearchTree;

import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;
import uy.edu.um.prog2.adt.Lista.PosInvalida;

public class NodeBST<K extends Comparable<K>, T> {

	private K key;
	private T data;

	private NodeBST<K, T> leftChild;
	private NodeBST<K, T> rightChild;

	public NodeBST(K key, T data) {
		this.key = key;
		this.data = data;

		leftChild = null;
		rightChild = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeBST<K, T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeBST<K, T> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeBST<K, T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeBST<K, T> rightChild) {
		this.rightChild = rightChild;

	}

	public NodeBST<K, T> findN(K key) {
		NodeBST<K,T> oExit = null;
		if (this.key == key) {
			oExit = this;
		} else if (this.leftChild == null && this.rightChild == null) {
			oExit = null;
		} else {
			if (this.leftChild != null) {
				oExit = leftChild.findN(key);
			}
			if (oExit == null && this.rightChild != null) {
				oExit = this.rightChild.findN(key);
			}
		}
		return oExit;
		}

		
	

	public List<T> inOrderN() {
		List<T> lista = new LinkedList<T>();

		try {
			if (leftChild != null) {
				for (int i = 0; i < leftChild.inOrderN().size(); i++)
					lista.add((T) leftChild.inOrderN().get(i));
			}
			lista.add(data);
			
			if (rightChild != null) {
				for (int i = 0; i < rightChild.inOrderN().size(); i++)
					lista.add((T) rightChild.inOrderN().get(i));
			}

		} catch (PosInvalida e) {

		}
		return lista;
	}

	public List<T> preOrderN() {
		List<T> lista = new LinkedList<T>();
		lista.add(data);

		try {
			if (leftChild != null) {
				for (int i = 0; i < leftChild.preOrderN().size(); i++) {
					lista.add((T) leftChild.preOrderN().get(i));
				}
			}
			if (rightChild != null) {
				for (int i = 0; i < rightChild.preOrderN().size(); i++)
					lista.add((T) rightChild.preOrderN().get(i));
			}
		} catch (PosInvalida e) {
		}

		return lista;
	}

	public List<T> postOrderN() {
		List<T> lista = new LinkedList<T>();
		try {

			if (leftChild != null) {
				for (int i = 0; i < leftChild.postOrderN().size(); i++)
					lista.add((T) leftChild.postOrderN().get(i));
			}

			if (rightChild != null) {
				for (int i = 0; i < rightChild.postOrderN().size(); i++)
					lista.add((T) rightChild.postOrderN().get(i));
			}
			lista.add(data);
		} catch (PosInvalida e) {
		}

		return lista;
	}

	public NodeBST<K, T> findMin() {
		NodeBST<K, T> oExit = null;

		if (leftChild == null) {
			oExit = this;
		} else {
			oExit = this.leftChild.findMin();
		}

		return oExit;
	}

	public NodeBST<K, T> findMax() {
		NodeBST<K, T> oExit = null;

		if (rightChild == null) {
			oExit = this;
		} else {
			oExit = this.rightChild.findMin();
		}

		return oExit;
	}

	public NodeBST<K, T> findPadre(K key) {
		NodeBST<K,T> parent=this;
		NodeBST<K,T> oExit = null;
		if((parent.getLeftChild()!=null && parent.getLeftChild().getKey()==key) || (parent.getRightChild()!=null && parent.getRightChild().getKey()==key)) {
			parent=this;
		}else {
			if(parent.getLeftChild()!=null && parent.getLeftChild().findPadre(key)!=null){
				parent=parent.getLeftChild().findPadre(key);			
			}else if(parent.getRightChild()!=null && parent.getRightChild().findPadre(key)!=null) {
				parent=parent.getRightChild().findPadre(key);
			}else{
				parent=null;
			}
		}
		return parent;
	}

}
