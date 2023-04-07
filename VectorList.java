
/**
 * Tom Chiapete
 * 
 * VectorList Class
 * A class that implements the ListInterface interface using a vector.
 * This also has some addition vector manipulation methods.
 * 
 * Assignment 3 redo
 * 
 */

import java.util.Vector;  // import the Vector class

public class VectorList implements ListInterface
{
    private Vector entry;  // declare a new vector
    
    // Default Constructor
    public VectorList()
    {
        entry = new Vector();
    }
    
    // Alternate Constructor.  Lets the user create a new VectorList 
    // of size 'initialSize'
    public VectorList(int initialSize)
    {
        entry = new Vector(initialSize);    
    }
    
    // add() method 
    // Add the newEntry object the next position on the list
    public boolean add(Object newEntry)
    {
        entry.addElement(newEntry);
        return true;
    }
    
    // add() method
    // Add the newEntry object the position specified, if possible.
    public boolean add(int newPosition, Object newEntry)
    {
        boolean isSuccessful = true; // 'will this method succeed' boolean
        if ((newPosition >= 1) && (newPosition <= entry.size()+1))
        {
            entry.insertElementAt(newEntry, newPosition-1);
        }
        else
        {
            isSuccessful = false;   
        }
        return isSuccessful;
    }
    
    // remove() method
    // Remove the object at the givenPosition, if possible.
    public Object remove(int givenPosition)
    {
        Object result = null; // the return value
        if ((givenPosition >=1) && (givenPosition <= entry.size()))
        {
            result = entry.elementAt(givenPosition - 1);
            entry.removeElementAt(givenPosition-1);
        }
        return result;
    }
    
    // clear() method
    // Wipes out the entire list by removing all object entries from 
    // the Vector.  Use an already-created Vector method.
    public void clear()
    {
        entry.removeAllElements();
    }
    
    /* replace() method
     * This takes in two parameters, a given position and a newEntry
     * integer.  This will take the object in the second parameter and 
     * replace it with the object in the givenPosition.
     */
    public boolean replace(int givenPosition, Object newEntry)
    {
        if ((givenPosition >=1) && (givenPosition <= entry.size()))
        {
            remove(givenPosition);
            add(givenPosition,newEntry);
            return true;
        }
        return false;
    }

    /* contains() method
     * This will simply go through the entire Vector and see if the 
     * object in the parameter can be found any place on the list.
     * Return a yes or no (boolean).
     */
    public boolean contains(Object anEntry)
    {
        for (int x = 1; x <= entry.size(); x++)
        {
            if (getEntry(x).equals(anEntry))
            {
                return true;
            }
        }
        return false;   
    }
    
    // isEmpty() method
    // Simply check and see if the Vector is empty.
    public boolean isEmpty()
    {
        return entry.isEmpty();   
    }
    
    /* isFull() method
     * This will go through the vector and see if any values in it are 
     * valued null.  If so, return false.  This means we don't have a full
     * list.
     */
    public boolean isFull()
    {
        for (int x = 1; x < entry.size(); x++)
        {
            if (getEntry(x).equals(null))
            {
                return false;
            }
        }        
        return true;   
    }
    
    /* display() method
     * This will print out the VectorList contents to a 
     * terminal screen in a clean way.
     */
    public void display()
    {
        for (int x = 1; x <= entry.size(); x++)
        {
            System.out.println("("+ x +")=====>  "+getEntry(x));
        }
    }
    
    // getLength() method
    // This returns the length of the Vector
    public int getLength()
    {
        return entry.size();
    }
    
    // getEntry() method
    // This method returns the object at the given position in the
    // vector, if possible.
    public Object getEntry(int givenPosition)
    {
        try
        {  
            if ((givenPosition <1) && (givenPosition > entry.size()))
                throw new Exception("Invalid givenPosition");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return entry.get(givenPosition-1); 
    }

    // reverse() method
    // Reverse the contents in the vector.
    public void reverse()
    {
        Vector tempVector = new Vector(entry.capacity()); // temp vector
        Object tempObject; // temporary holding object.
        int y = entry.size();  // count down variable.
        for (int x = 1; x <= entry.size(); x++)
        {
            tempObject = getEntry(y--);
            tempVector.add(tempObject);
        }
        entry = tempVector;  // point back to entries
    }
    
    /* cycle() method
     * This method takes in a parameter and will cycle or bump up/bump down 
     * the entries in the vector by number numCycles.
     * 
     * This is done by creating a temporary vector and placing the 
     * 'cycled' entries in that.  It is then pointed back to our original 
     * vector entries.
     */
    public void cycle(int numCycles)
    {
        // Lets trim this entry vector so we only have entries with
        // actual values in them.  Also, this makes my life a whole lot
        // easier.
        entry.trimToSize();
        
        // Make numbers over the vector size and under zero useable.
        if (numCycles > getLength())
        {
            numCycles = numCycles % getLength();   
        }
        if (numCycles < 0)
        {
            numCycles = getLength() - (Math.abs(numCycles) % getLength());   
        }
        
        // Create a temporary vector to use to put in 'cycled' entries.
        Vector tempVector = new Vector(entry.size());
        
        /* Set all entries in the current vector to null.  This increases the 
         * size of the vector in our temporary vector to the size of the 
         * actual entry vector.
         * Without this loop, I run into size exceptions, because the 
         * list size equal to zero.
         */
        for (int x = 1; x <= entry.size(); x++)
        {
            tempVector.add(null);
        }
        
        // This will hold the temporary object getting copied from
        // the entry vector to the tempVector Vector.
        Object tempObject;
        
        // The for loop to do the actual cycling.
        for (int x = 1; x <=entry.size(); x++)
        {
            tempObject = getEntry(x);
            if (x + numCycles <= getLength())
            {
                tempVector.set(x+numCycles-1,tempObject);
            }
            else
            {
                tempVector.set(x+numCycles - getLength() -1,tempObject);
            }

        }
        entry = tempVector;
    }
    
    // swap() method
    // Attempt to swap the first object's position with the 
    // second object's position.
    public boolean swap(int first, int second)
    {
        // Test to see if the positions are useable.
        if (first < 0 || first > entry.size() 
            || second < 0 || second > entry.size())
        {
            return false;
        }
        Object temp1 = getEntry(first); // temp object with 'first' contents
        Object temp2 = getEntry(second); // temp object with 'second' contents
        entry.set(first-1,temp2);
        entry.set(second-1,temp1);
        return true;    
    }
    
    /* equals() method
     * Test for equality between two VectorLists.
     * 
     * Return false if the parameter is not an instance of VectorList.
     * 
     * Return false immediately after some value
     * in the VectorList doesn't match.
     */    
    public boolean equals(Object otherObject)
    {
        if (otherObject instanceof VectorList)
        {
            VectorList otherVector = (VectorList) otherObject;
            for (int x = 1; x <= entry.size(); x++)
            {
                if (!getEntry(x).equals(otherVector.getEntry(x)))
                {
                    return false;
                }
            }            
            return true;
        }
        else
        {
            return false;
        }
    }

}
