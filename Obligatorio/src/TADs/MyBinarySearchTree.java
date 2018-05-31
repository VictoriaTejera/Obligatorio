package TADs;



public interface MyBinarySearchTree <K extends Comparable<K>, T>{

	public T find(K key);
	public void insert(K key, T data);
	public void delete(K key) throws InvalidKey;
	
	
	
	public List<T> inOrder();

	public List<T> preOrder();

	public List<T> postOrder();
}
