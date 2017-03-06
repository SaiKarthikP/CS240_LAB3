
import java.util.Random;

public class Test extends CustomerQueue{
	private static int lostCustomerDay;

	public static void main(String[] args) {
		System.out.println("Menu:");
		System.out.println("(1) Burger - Bun, Patty, Lettuce, Tomato, Onion	");
		System.out.println("(2) Cheese Burger - Cheese, Bun, Patty, Lettuce, Tomato, Onion");
		System.out.println("(3) Vegan lettuce wrap Burger - (NO Bun, No Patty),2 order of Lettuce, Tomato, Onion");
		System.out.println("(4) Burger No Onion - (No Onion), Bun, Patty, Lettuce, Tomato, ");
		System.out.println("(5) Cheese Burger No Onion - (No Onion), Cheese, Bun, Patty, Lettuce, Tomato");
		System.out.println("(6) Burger No Tomato - (No Tomato), Bun, Patty, Lettuce, Onion");
		
		Inventory inv = new Inventory();
		WaitLine queue = new WaitLine();
		
		
		
		for (int date = 1; date <= 31; date++){
			if ((date+2)%3 == 0){
				inv.reStock(date);
			}
			for (int hour = 10; hour < 20; hour++){
				int numOfCustomers = RandomNumber(1, 100);
				if (numOfCustomers > 50){
					lostCustomerDay = lostCustomerDay + (numOfCustomers - 50);
					numOfCustomers = 50;
				}
				for (int customer=1; customer<=numOfCustomers; customer++){
					int order = RandomNumber(1,6);
					if (inv.checkAvailability(order)) //check availability of ingredients
						lostCustomerDay++;
					else{
						queue.addToQueue(order);
						inv.customerOrder(order);
					}
				}
			}
			inv.sortStacks();
			inv.checkExpiry(date);
			System.out.println("Date: 03/" + date + "/2017 " + "Customers Lost: " + lostCustomerDay);
			System.out.println(inv.wasteToString());
			System.out.println(queue.orderToString());
		}
	
	}
	
	public void reStock(int day){
		
	}

	public static int RandomNumber(int min, int max){
  		Random randomObj = new Random(); 
  		return randomObj.nextInt((max - min) + 1) + min;  
   		
	}
}
