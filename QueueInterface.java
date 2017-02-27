package cs240_lab3;

import cs240_lab3.EmptyQueueException;


public interface QueueInterface
{
  /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
  public void enqueue(int newEntry);
  
  /** Removes and returns the entry at the front of this queue.
      @return  The object at the front of the queue. 
      @throws  EmptyQueueException if the queue is empty before the operation. */
  public int dequeue();
  
  /**  Retrieves the entry at the front of this queue.
      @return  The object at the front of the queue.
      @throws  EmptyQueueException if the queue is empty. */
  public int getFront();
  
  /** Detects whether this queue is empty.
      @return  True if the queue is empty, or false otherwise. */
  public boolean isEmpty();
  
  /** Removes all entries from this queue. */
  public void clear();
} // end QueueInterface
