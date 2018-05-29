package uy.edu.um.prog2.adt.Lista;

public interface List<T> {
	public void add(T nValue);
	public T get(int pos) throws PosInvalida;
	public int size();
	public void delete(int pos) throws PosInvalida;
	public boolean isOnList(T valor);
	public void addFirst(T valor);
}
