package school.EDDA30.Ovn5;

import java.util.ArrayList;
import java.util.List;

public class MyStack<E> implements Stack {

	List<Object> stack = new ArrayList<>();


	@Override
	public Object pop() {
		if (!isEmpty()) {
			Object e = stack.get(0);
			stack.remove(0);
			return e;
		}
		return null;
	}

	@Override
	public Object peek() {
		return stack.get(0);
	}

	@Override
	public void push(Object x) {
		stack.add(0, x);
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
}
