package List;

/*LinkedList is a sequential list of nodes that hold data which point to other nodes also containing data
*     4 -> -2 -> 3 -> 1 -> 6
* When is it used?:
* 1) In many List, Stack and Queue Implementations
* 2) Great for creating circular lists
* 3) Can easily model real world objects such as trains
* 4) Used in separate chaining which is present in certain Hashtable implementations to deal with hashing collisions
* 5) Often used in the implementation of adjacency lists for graphs.
*
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class L2_LinkedList {
    public static void main(String[] args) {
        //Creating a linked list
        LinkedList<Integer> lList = new LinkedList<Integer>();

        //Adding elements to linked list
        lList.add(4);
        lList.add(-2);
        lList.add(3);
        lList.add(1);
        lList.add(6);
        lList.add(2,10); //add element 10 at idx 2

        //Copy the arraylist
        LinkedList new_lList = (LinkedList) lList.clone();

        //Convert linked list to array
        Object[] arr = lList.toArray();

        //Returns the index of the specified element; (-1 if not found)
        int idx = lList.lastIndexOf("2");
        System.out.println("2 is at index = "+idx);

        //Check if the linked list contains the specified element
        System.out.println(lList.contains(3));

        //Remove elements from linked list
        lList.removeFirst(); //removes the head of the linked list (the 1st element)
        lList.removeLast(); //removes the tail of the linked list (the last element)
        lList.remove(3); //remove element using index
        lList.remove("3"); //remove element using element

        //Clear all elements in the linked list
        new_lList.clear();

        //Fetch the element in the list using the index
        System.out.println(lList.get(0));

        //Check if the arraylist is empty
        System.out.println("Is the LinkedList empty?: " + new_lList.isEmpty());

        Iterator itr = lList.iterator();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");

    }
}
