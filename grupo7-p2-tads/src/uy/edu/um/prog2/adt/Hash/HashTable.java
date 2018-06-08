package uy.edu.um.prog2.adt.Hash;

public interface HashTable<K,T> {
	
	
	public void insertar (K clave, T valor) throws ElementoYaExistenteException;
	public boolean pertenece (K clave);
	public void borrar (K clave)throws ClaveInvalida;
	public T obtener(K key);
}
