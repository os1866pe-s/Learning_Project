package school.EDDA30.Ovn7;

import school.EDDA30.Ovn6.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.IntStream;

public class ArrayCollection<E> implements Collection<E> {

	private E[] theCollection;
	private int size;

	/***/
	public ArrayCollection(){
		theCollection = (E[]) new Object[10];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(E e) {
		if (size == theCollection.length){
			doubleArray();
		}
		theCollection[size] = e;
		size++;
		return true;
	}

	private void doubleArray(){
		E[] tempCollection = (E[]) new Object[theCollection.length * 2];

		IntStream.range(0, theCollection.length)
				.forEach(x -> tempCollection[x] = theCollection[x]);

		theCollection = tempCollection;
	}

	@Override
	public boolean contains(Object o) {
		return Arrays.stream(theCollection)
				.anyMatch(e -> e.equals(o));
	}


	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		theCollection = (E[]) new Object[10];
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (theCollection[i].equals(o)){
				theCollection[i] = null;
				return true;
			}
		}

		return false;
	}






	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}
}
