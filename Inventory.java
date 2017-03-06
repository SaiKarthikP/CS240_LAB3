
import java.util.Random;


public class Inventory extends FoodStack {
	private int wasteCheese, wasteBun, wastePatty, wasteLettuce, wasteTomato, wasteOnion;
	FoodStack bunStack;
	FoodStack pattyStack;
	FoodStack lettuceStack;
	FoodStack tomatoStack;
	FoodStack onionStack;
	FoodStack cheeseStack;
	
	int bunCount = 0, pattyCount = 0, lettuceCount = 0, tomatoCount = 0, onionCount = 0, cheeseCount = 0;
	
	public Inventory(){
		bunStack = new FoodStack();
		pattyStack = new FoodStack();
		lettuceStack = new FoodStack();
		tomatoStack = new FoodStack();
		onionStack = new FoodStack();
		cheeseStack = new FoodStack();
		
	}
	
	public void reStock(int date){
		int bunExpiry = 305+date;
		int pattyExpiry = 304+date;
		int lettuceExpiry = 303+date;
		int tomatoExpiry = 303+date;
		int onionExpiry = 305+date;
		int cheeseExpiry = 302+date;
		int stockBun = RandomNumber(700,1000);
		bunCount += stockBun;
		int stockPatty = RandomNumber(700,1000);
		pattyCount += stockPatty;
		int stockLettuce = RandomNumber(700,1000);
		lettuceCount += stockLettuce;
		int stockTomato = RandomNumber(700,1000);
		tomatoCount += stockTomato;
		int stockOnion = RandomNumber(700,1000);
		onionCount += stockOnion;
		int stockCheese = RandomNumber(700,1000);
		cheeseCount += stockCheese;
		
		for(int i=1; i<=stockBun;i++){
			bunStack.push(bunExpiry);
		}
		for(int i=1; i<=stockPatty;i++){
			pattyStack.push(pattyExpiry);
		}
		for(int i=1; i<=stockLettuce;i++){
			lettuceStack.push(lettuceExpiry);
		}
		for(int i=1; i<=stockTomato;i++){
			tomatoStack.push(tomatoExpiry);
		}
		for(int i=1; i<=stockOnion;i++){
			onionStack.push(onionExpiry);
		}
		for(int i=1; i<=stockCheese;i++){
			cheeseStack.push(cheeseExpiry);
		}
	}
	public void sortStacks(){
    SortArray.<Integer>selectionSort(bunStack.expiry, bunCount);
    SortArray.<Integer>selectionSort(pattyStack.expiry, pattyCount);
    SortArray.<Integer>selectionSort(lettuceStack.expiry, lettuceCount);
    SortArray.<Integer>selectionSort(tomatoStack.expiry, tomatoCount);
    SortArray.<Integer>selectionSort(onionStack.expiry, onionCount);
    SortArray.<Integer>selectionSort(cheeseStack.expiry, cheeseCount);
	}
	
	public void customerOrder(int menuItem){
		if (menuItem == 1){
			bunStack.pop();
			pattyStack.pop();
			lettuceStack.pop();
			tomatoStack.pop();
			onionStack.pop();
		}else if  (menuItem == 2){
			bunStack.pop();
			pattyStack.pop();
			lettuceStack.pop();
			tomatoStack.pop();
			onionStack.pop();
			cheeseStack.pop();
		}else if  (menuItem == 3){
			lettuceStack.pop();
			lettuceStack.pop();
			tomatoStack.pop();
			onionStack.pop();
		}else if  (menuItem == 4){
			bunStack.pop();
			pattyStack.pop();
			lettuceStack.pop();
			tomatoStack.pop();
		}else if  (menuItem == 5){
			bunStack.pop();
			pattyStack.pop();
			lettuceStack.pop();
			tomatoStack.pop();
			cheeseStack.pop();
		}else if  (menuItem == 6){
			bunStack.pop();
			pattyStack.pop();
			lettuceStack.pop();
			onionStack.pop();
		}
	}
	
	public void checkExpiry(int date){
		int today = 300+date;
		
		while (!bunStack.isEmpty() && bunStack.peek() <= today) {
			bunStack.pop();
			wasteBun++;
			bunCount--;
		}
		while (!pattyStack.isEmpty() && pattyStack.peek() <= today ){
			pattyStack.pop();
			wastePatty++;
			pattyCount--;
		}
		while (!lettuceStack.isEmpty() && lettuceStack.peek() <= today) {
			lettuceStack.pop();
			wasteLettuce++;
			lettuceCount--;
		}
		while (!tomatoStack.isEmpty() && tomatoStack.peek() <= today)  {
			tomatoStack.pop();
			wasteTomato++;
			tomatoCount--;
		}
		while (!onionStack.isEmpty() && onionStack.peek() <= today ){
			onionStack.pop();
			wasteOnion++;
			onionCount--;
		}
		while (!cheeseStack.isEmpty() && cheeseStack.peek() <= today ){
			cheeseStack.pop();
			wasteCheese++;
			cheeseCount--;
		}
	}
	
	public static int RandomNumber(int min, int max){
  		Random randomObj = new Random(); 
  		return randomObj.nextInt((max - min) + 1) + min; 
   		
	}

	public boolean checkAvailability(int order) {
		boolean notAvailable = false;
		if (order == 1){
			if (bunStack.isEmpty() || pattyStack.isEmpty() || lettuceStack.isEmpty() || tomatoStack.isEmpty() || onionStack.isEmpty())
				notAvailable = true;
		}else if  (order == 2){
			if (bunStack.isEmpty() || pattyStack.isEmpty() || lettuceStack.isEmpty() || tomatoStack.isEmpty() || onionStack.isEmpty() || cheeseStack.isEmpty())
				notAvailable = true;
			
		}else if  (order == 3){
			if (lettuceCount < 2 || tomatoStack.isEmpty() || onionStack.isEmpty())
				notAvailable = true; //need to check for 2 lettuce here

		}else if  (order == 4){
			if (bunStack.isEmpty() || pattyStack.isEmpty() || lettuceStack.isEmpty() || tomatoStack.isEmpty())
				notAvailable = true;
			
		}else if  (order == 5){
			if (bunStack.isEmpty() || pattyStack.isEmpty() || lettuceStack.isEmpty() || tomatoStack.isEmpty() || cheeseStack.isEmpty())
				notAvailable = true;
			
		}else if  (order == 6){
			if (bunStack.isEmpty() || pattyStack.isEmpty() || lettuceStack.isEmpty() || onionStack.isEmpty())
				notAvailable = true;
		}
		return notAvailable;
		
	}
	
	public String wasteToString(){
		return "Waste Cheese: " + wasteCheese + ", Waste Bun: " +  wasteBun + ", Waste Patty: " + wastePatty + ", Waste Lettuce: " + wasteLettuce + ", Waste Tomato: " + wasteTomato + ", Waste Onion: " +  wasteOnion;
	}
}
