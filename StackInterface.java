package cs240_lab3;

	public interface StackInterface
	{
	   /** Adds a new entry to the top of this stack.
	       @param newEntry  An object to be added to the stack. */
	   public void push(int newEntry);
	  
	   /** Removes and returns this stack's top entry.
	       @return  The object at the top of the stack. 
	       @throws  EmptyStackException if the stack is empty before the operation. */
	   public int pop();
	  
	   /** Retrieves this stack's top entry.
	       @return  The object at the top of the stack.
	       @throws  EmptyStackException if the stack is empty. */
	   public int peek();
	  
	   /** Detects whether this stack is empty.
	       @return  True if the stack is empty. */
	   public boolean isEmpty();
	  
	   /** Removes all entries from this stack. */
	   public void clear();
	} // end StackInterface
