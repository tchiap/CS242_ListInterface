
/**
 * Tom Chiapete
 * 
 * TestVectorList Class
 * A class that tests the VectorList class by running some tests in the
 * terminal.
 * 
 * Assignment 3 redo
 */

public class TestVectorList
{

    // instance variables - replace the example below with your own
    public static void main(String [] args)
    {
        
        // Create a VectorList
        VectorList list1 = new VectorList();
        System.out.println("Created VectorList");
        System.out.println();
        
        // Test isEmpty
        boolean isListEmpty = list1.isEmpty();
        if (isListEmpty)
        {
            System.out.println("Tested isEmpty... Returned True");   
        }
        System.out.println();
        
        // Start adding some strings to the VectorList
        list1.add("Sunday");
        System.out.println("Added String 'Sunday'");  
        list1.add("Monday");
        System.out.println("Added String 'Monday'");  
        list1.add("Tuesday");
        System.out.println("Added String 'Tuesday'");  
        System.out.println();
        
        // Add "Wednesday" using alternate add method.
        list1.add(4,"Wednesday");
        System.out.println("Adding String 'Wednesday' to Position 4");
        System.out.println();
        
        // Remove "Wednesday" is in position 4.
        list1.remove(4);
        System.out.println("Removing the String Object in Position 4");
        
        // Output what we have so far.
        System.out.println();  
        System.out.println("Output Current List:");
        list1.display();
        
        // Add some more stuff to our vector list.
        list1.add("Wednesday");
        System.out.println("Added String 'Wednesday', again"); 
        list1.add("Thursday");
        System.out.println("Added String 'Thursday'");
        list1.add("Friday");
        System.out.println("Added String 'Friday'");
        list1.add("Saturday");
        System.out.println("Added String 'Saturday'");
        
        // Output what we have so far.
        System.out.println();  
        System.out.println("Output Current List:");
        list1.display();
        
        // Attempt to reverse the list.
        list1.reverse();
        System.out.println("Reversing the list");
        System.out.println();  
        System.out.println("Output Current List:");
        list1.display();  
        
        // Reverse it back so it's now back to normal.
        list1.reverse();
        System.out.println("Reversing the list again");
        System.out.println();  
        System.out.println("Output Current List:");
        list1.display();  
        
        // Attempt to use the swap method.
        list1.swap(1,7);
        System.out.println("Swap Sunday and Saturday");
        System.out.println();  
        System.out.println("Output Current List:");
        list1.display();
        
        // Swap them back.
        list1.swap(1,7);
        System.out.println("Swap Saturday and Sunday back");
        System.out.println();  
        System.out.println("Output Current List:");
        list1.display();
        
        // Create a new VectorList with the same contents.
        System.out.println();  
        System.out.println("Creating an identical list.");
        VectorList list2 = new VectorList();
        System.out.println("Created another VectorList");
        System.out.println();
        list2.add("Sunday");
        list2.add("Monday");
        list2.add("Tuesday");
        list2.add("Wednesday");
        list2.add("Thursday");
        list2.add("Friday");
        list2.add("Saturday");
        System.out.println();
        
        // Test to see if list1 and list2 are equal (they should be)
        System.out.println("Testing equality between list1 and list2");
        boolean isEqual = false;
        if (list1.equals(list2))
        {
            isEqual = true;   
        }
        System.out.println("isEqual returned:  "+isEqual);
        
        // We'll change something by replacing 'Thursday' with 'Pay Day'.
        // This will force an inequality.
        
        // Test for replace method.
        System.out.println("Replace 'Thursday' in list2 with 'Pay Day'");  
        list2.replace(5,"Pay Day");
        list2.display(); 
        
        // Test for equals method.
        System.out.println("Now testing equality between list1 and list2");
        isEqual = false;
        if (list1.equals(list2))
        {
            isEqual = true;   
        }
        System.out.println("isEqual returned:  "+isEqual);
        
        // Test clear method.  Shouldn't print out anything when display()
        // is called.  We don't have any contents in our list2.
        System.out.println();
        System.out.println("Clear out list2 using clear method");        
        list2.clear();
        System.out.println("Print out vector contents if there are any."); 
        list2.display();         
        System.out.println("-- Should have printed out nothing."); 
        System.out.println();
        
        // Test contains method.
        System.out.println("Test contains method.");
        System.out.println("Test to see if Sunday is on our list");
        boolean isContains = list1.contains("Sunday");
        System.out.println("isContains returned "+isContains);
        System.out.println("Test to see if July is on our list");
        isContains = list1.contains("July");
        System.out.println("isContains returned "+isContains);
        System.out.println();
        
        // Test isFull method
        boolean isFull = list1.isFull();
        System.out.println("Test isFull: "+isFull);
        
        // Test isEmpty method
        boolean isEmpty = list1.isEmpty();
        System.out.println("Test isEmpty: "+isEmpty);
        System.out.println();
        
        // Print out the length of the vector
        System.out.println("Current Vector Length: "+list1.getLength());
        System.out.println();
        
        // Print out the object found in the 2nd position of the vector.
        System.out.println("Get object in position 2: "+list1.getEntry(2));
        System.out.println();
        
        // Test out cycle of +2.
        list1.cycle(2);
        System.out.println("Try cycle    +2");  
        System.out.println("Output Current List:");
        list1.display();
        System.out.println();
        
        // Test out cycle of -2.
        list1.cycle(-2);
        System.out.println("Try cycle    -2");  
        System.out.println("Output Current List:");
        list1.display(); 
        System.out.println();
        
        // Test out cycle of 27.
        list1.cycle(27);
        System.out.println("Try cycle    +27");  
        System.out.println("Output Current List:");
        list1.display(); 
        System.out.println();
        
        // Test out cycle of -27.
        list1.cycle(-27);
        System.out.println("Try cycle    -27");  
        System.out.println("Output Current List:");
        list1.display(); 
        System.out.println();
        
        // Test out cycle of -0.
        list1.cycle(0);
        System.out.println("Try cycle    0");  
        System.out.println("Output Current List:");
        list1.display(); 
        System.out.println();
    }
}





