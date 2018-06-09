package uy.edu.um.prog2.adt.Iterator;

import java.util.Iterator;

import uy.edu.um.prog2.adt.Hash.NodoHash;



public class MyIterator<K,T> implements Iterator<T> {

	protected int posicion = 0;
	protected NodoHash<K, T>[] vectorHash;

	public MyIterator(NodoHash<K,T>[] vector) {
		
		vectorHash=vector;
		
		while(vectorHash[posicion]==null  || vectorHash[posicion].isEliminado()) {
			posicion++;
		}

	}

	
	public boolean hasNext() {
		
		boolean bExit=false;
		
		int count =posicion;
		 while(!bExit && count< vectorHash.length) {
			 
			 if(vectorHash[count]!=null && !vectorHash[count].isEliminado()) {
				 bExit = true;
			 }
			 count++;
		 }
		
		return bExit;
	}


	public T next() {
		
		T	oExit=null;
	
		
		while( oExit == null && posicion<vectorHash.length) {
			
			if(vectorHash[posicion]!=null && !vectorHash[posicion].isEliminado()) {
				oExit=vectorHash[posicion].getValor();
			}
			posicion++;
			
		}
		return oExit;
	}

}
