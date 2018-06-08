package uy.edu.um.prog2.adt.Hash;

import java.util.Iterator;

public interface HashTable<K,T> extends Iterable<T> {
	
	
	public void insertar (K clave, T valor) throws ElementoYaExistenteException;
	public boolean pertenece (K clave);
	public void borrar (K clave)throws ClaveInvalida;
	public T obtener(K key);
	public Iterator iterator();
}
