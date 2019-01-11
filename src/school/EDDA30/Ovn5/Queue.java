package school.EDDA30.Ovn5;

public interface Queue<E> {

	public E poll();

	public E peek();

	public void offer(E x);

	public boolean isEmpty();
}
