package school.EDDA30.Ovn8;

import java.util.NoSuchElementException;

public class SingleLinkedList<E> {

	private ListNode<E> first;

	public SingleLinkedList() {
		first = null;
	}

	/**
	 * Inserts the element at the beginning of the list
	 *
	 * @param e the element which is added
	 */
	public void addFirst(E e) {
		ListNode<E> n = new ListNode<>(e);
		n.next = first;
		first = n;
	}

	/**
	 * Returns the first element in the list.
	 *
	 * @return the first element in the list
	 */
	public E getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}

		return first.element;
	}

	/**
	 * Returns the last element in the list.
	 *
	 * @return the last element in the list
	 */
	public E getLast() {
		if (first == null) {
			throw new NoSuchElementException();
		}

		ListNode<E> listNode = first;
		while (listNode.next != null) {
			listNode = listNode.next;
		}

		return listNode.element;
	}

	/**
	 * Returns is the list contains a specific element.
	 *
	 * @param e the element which will be checked.
	 * @return true if the element is found, otherwise false.
	 */
	public boolean contains(Object e) {

		ListNode<E> listNode = first;
		while (listNode != null) {
			if (listNode.element.equals(e)) {
				return true;
			}

			listNode = listNode.next;
		}

		return false;
	}

	/**
	 * Removes the element e if the list contains it.
	 *
	 * @param e the element which will be checked for removal
	 * @return true if the element is found
	 */
	public boolean remove(Object e) {
		if (first == null) {
			return false;
		}else {
			if (first.element.equals(e)) {
				first = first.next;
				return true;
			}
		}

		ListNode<E> prevNode = first;
		ListNode<E> nowNode = first.next;

		while (nowNode != null){
			if (nowNode.element.equals(e)){
				prevNode.next = nowNode.next;
				return true;
			}
			prevNode = nowNode;
			nowNode = nowNode.next;
		}
		return false;
	}

	/**A node which contain both a element and the next node.*/
	private static class ListNode<E> {

		private E element;
		private ListNode<E> next;

		/**
		 * Creates a listnode with the element e.
		 *
		 * @param e the element which is inserted in the current node
		 */
		private ListNode(E e) {
			element = e;
			next = null;
		}
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();

		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);

		System.out.println(list.remove(3));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
	}
}
