package cs240_lab3;

import cs240_lab3.EmptyQueueException;


public class CustomerQueue implements QueueInterface{
	private int[] queue;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_CAPACITY = 50;
	
	public CustomerQueue() {
		this(DEFAULT_CAPACITY);
	}
	

	public CustomerQueue(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		int[] temp = new int[initialCapacity + 1];
		queue = temp;
		frontIndex = 0;
		backIndex = initialCapacity;
	}
	
	public int queueLength(){
		return queue.length;
	}

	private void checkCapacity(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enqueue(int newEntry) {
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}

	private void ensureCapacity() {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public int dequeue() {
		if (isEmpty())
			throw new EmptyQueueException();
		else{
			int front = queue[frontIndex];
			queue[frontIndex] = (Integer) null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	}

	@Override
	public int getFront() {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return queue[frontIndex];
	}

	@Override
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);
		
	}

	@Override
	public void clear() {
		frontIndex = 0;
		backIndex = queue.length - 1;
	}

}