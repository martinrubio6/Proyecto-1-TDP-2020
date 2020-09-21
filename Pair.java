package Ejercicio_4;

public class Pair<K,V> {
	
	protected K key;
	protected V value;
	
	public Pair(K key,V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	public String toString() {
		return "["+ getKey() + " , "+ getValue() + "]" ;
	}

}
