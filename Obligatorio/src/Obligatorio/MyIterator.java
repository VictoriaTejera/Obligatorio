package Obligatorio;

import java.util.Iterator;

import uy.edu.um.prog2.adt.Hash.NodoHash;



public class MyIterator<K extends Comparable<K>, T> implements Iterator<T> {

	protected int posicion = 0;
	protected NodoHash<K, T>[] unHash;

	public MyIterator(NodoHash<K,T>[] vector) {
		
		unHash=vector;
		
		while(unHash[posicion]==null  || unHash[posicion].isEliminado()) {
			posicion++;
		}

	}

	@Override
	public boolean hasNext() {
		
		boolean bExit=false;
		
		int count =posicion;
		 while(!bExit && count< unHash.length) {
			 
			 if(unHash[count]!=null && !unHash[count].isEliminado()) {
				 bExit = true;
			 }
			 count++;
		 }
		
		return bExit;
	}

	@Override
	public T next() {
		
		T oExit = unHash[posicion].getValor();
		posicion++;
		
		while(posicion<unHash.length && ( unHash[posicion] == null || unHash[posicion].isEliminado() )) {
			posicion++;
		}
		return oExit;
	}

}