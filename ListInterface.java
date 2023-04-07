/** An interface for the ADT list.
* Entries in the list have positions that begin with 1.
* 
* This code is from Chapter 4 of 
* Data Structures and Abstractions with Java
*      by Carrano and  Savitch.
*/
    
    
public interface ListInterface
{
/** Task: Adds a new entry to the end of the list.
* @param newEntry the object to be added as a new entry
* @return true if the addition is successful, or false if not */
    
    
public boolean add(Object newEntry);
/** Task: Adds a new entry at a specified position within
* the list. Entries originally at and above the specified
* position are at the next higher position within the list.
* The list�s size is increased by 1.
* @param newPosition an integer that specifies the desired
* position of the new entry; newPosition >= 1
* and newPosition <= getLength()+1
* @param newEntry the object to be added as a new entry
* @return true if the addition is successful, or false if not */
    
    
public boolean add(int newPosition, Object newEntry);
/** Task: Removes the entry at a given position from the list.
* Entries originally at positions higher than the given
* position are at the next lower position within the list,
* and the list�s size is decreased by 1.
* @param givenPosition an integer that indicates the position of
* the entry to be removed; givenPosition >= 1
* and givenPosition <= getLength()
* @return either the entry at position givenPosition, if the removal
* was successful, or null */
public Object remove(int givenPosition);
    
    
/** Task: Removes all entries from the list. */
public void clear();
/** Task: Replaces the entry at a given position in the list.
* @param givenPosition an integer that indicates the position of the
* entry to be replaced; givenPosition >= 1
* and givenPosition <= getLength()
* @param newEntry the object that will replace the entry at the
* position givenPosition
* @return true if the replacement occurs, or false if either the
* list was empty or givenPosition is invalid */
public boolean replace(int givenPosition, Object newEntry);
    
    
/** Task: Retrieves the entry at a given position in the list.
* @param givenPosition an integer that indicates the position of
* the desired entry; givenPosition >= 1
* and givenPosition <= getLength()
* @return a reference to the indicated list entry, if found,
* otherwise returns null */
public Object getEntry(int givenPosition);
    
    
/** Task: Determines whether the list contains a given entry.
* @param anEntry the object that is the desired entry
* @return true if the list contains anEntry, or false if not */
public boolean contains(Object anEntry);
    
    
/** Task: Gets the length of the list.
* @return the integer number of entries currently in the list */
public int getLength();
    
    
/** Task: Determines whether the list is empty.
* @return true if the list is empty, or false if not */
public boolean isEmpty();
    
    
/** Task: Determines whether the list is full.
* @return true if the list is full, or false if not */
public boolean isFull();
    
    
/** Task: Displays all entries that are in the list, one per
* line, in the order in which they occur in the list. */
public void display();
    
    
} // end ListInterface