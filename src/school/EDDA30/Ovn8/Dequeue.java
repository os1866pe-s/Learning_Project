package school.EDDA30.Ovn8;

public class Dequeue<E> {

	private Node<E> first;
	private Node<E> last;

	public Dequeue() {
		first = null;
		last = null;
	}

	public void addFirst(E e) {
		Node<E> newFirst = new Node<>(e);
		if (first == null) {
			first = newFirst;
			last = newFirst;
		} else {
			newFirst.next = first;
			first = newFirst;
		}
	}

	public void addLast(E e) {
		Node<E> newLast = new Node<>(e);
		if (last == null) {
			first = newLast;
			last = newLast;
		} else {
			last.next = newLast;
			last = newLast;
		}
	}

	public E removeFirst() {
		if (first == null) {
			return null;
		} else {
			E wasFirst = first.element;
			first = first.next;
			if (first == null) {
				last = null;
			}

			return wasFirst;
		}
	}

	public E removeLast() {
		if (first == null) {
			return null;
		} else {
			E wasLast = last.element;
			if (first == last) {
				first = null;
				last = null;
			}else{
				Node<E> p = first;
				while (p.next != last){
					p = p.next;
				}
				last = p;
				p.next = null;
			}
			return wasLast;
		}
	}


	private static class Node<E> {

		private E element;
		private Node<E> next;


		private Node(E element) {
			this.element = element;
			next = null;

		}
	}
}
