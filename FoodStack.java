package cs240_lab3;
import java.util.Arrays;
import java.util.EmptyStackException;

public class FoodStack implements StackInterface{
	private Integer[] expiry;    // Array of stack entries
	private int topIndex; // Index of top entry
   private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 5000;
	private static final int MAX_CAPACITY = 10000;
	
	public FoodStack()
	{
      this(DEFAULT_CAPACITY);
 	} // end default constructor
	
	public FoodStack(int initialCapacity)
	{
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      Integer[] tempStack = new Integer[initialCapacity];
      expiry = tempStack;
		topIndex = -1;
      initialized = true;
	} // end constructor

	public void push(int newEntry)
	{
		checkInitialization();
		ensureCapacity();
		expiry[topIndex + 1] = newEntry;
		topIndex++;
	} // end push

	public int peek()
	{
		checkInitialization();
		if (isEmpty())
			throw new EmptyStackException();
		else
         return expiry[topIndex];
	} // end peek

	@SuppressWarnings("null")
	public int pop()
	{
		checkInitialization();
		if (isEmpty())
			throw new EmptyStackException();
		else
		{
			int top = expiry[topIndex];
			expiry[topIndex] = null;
			topIndex--; 
         return top;
		} // end if
   } // end pop

   public boolean isEmpty()
	{
		return topIndex < 0;
	} // end isEmpty
	
	public void clear()
	{
		checkInitialization();
      
      // Remove references to the objects in the stack,
      // but do not deallocate the array
		while (topIndex > -1)
      {
			expiry[topIndex] = 0;
         topIndex--;
      } // end while
      //	Assertion: topIndex is -1	
	} // end clear
   
   // Throws an exception if this object is not initialized.
   private void checkInitialization()
   {
      if (!initialized)
         throw new SecurityException ("ArrayStack object is not initialized properly.");
   } // end checkInitialization
   
   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a stack " +
                                         "whose capacity exceeds " +
                                         "allowed maximum.");
   } // end checkCapacity
    
   // Doubles the size of the array stack if it is full
   // Precondition: checkInitialization has been called.
	private void ensureCapacity()
	{
 	   if (topIndex >= expiry.length - 1) // If array is full, double its size
      {
         int newLength = 2 * expiry.length;
         checkCapacity(newLength);
         expiry = Arrays.copyOf(expiry, newLength);
      } // end if
	} // end ensureCapacity

	
} // end ArrayStack