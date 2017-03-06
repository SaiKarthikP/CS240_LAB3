
public class WaitLine extends CustomerQueue {
	
	private int countItemOne, countItemTwo, countItemThree, countItemFour, countItemFive, countItemSix;
	CustomerQueue queue;
	
	public WaitLine(){
		queue = new CustomerQueue();
	}
	
	public void addToQueue(int order){
		queue.enqueue(order);
		if (order == 1)
			countItemOne++;
		else if (order == 2)
			countItemTwo++;
		else if (order == 3)
			countItemThree++;
		else if (order == 4)
			countItemFour++;
		else if (order == 5)
			countItemFive++;
		else if (order == 6)
			countItemSix++;
	}
	
	public int getLength(){
		return queue.queueLength();
	}
	
	public String orderToString(){
		return "Orders for Item 1: " + countItemOne + " Orders for Item 2: " + countItemTwo + " Orders for Item 3: " + countItemThree + " Orders for Item 4: " + countItemFour + " Orders for Item 5: " + countItemFive + " Orders for Item 6: " + countItemSix;
	}
}
