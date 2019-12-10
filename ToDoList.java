import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 * Name : ToDoList
 *
 * Functions:
 * - Stores ToDoEntry objects in Array List.
 * -Also manages tasks of addind additional objects, removing objects,
 *  finding objects and displaying objects in order.
 *
 * @author (Mark Carvalho)
 * 
 * @version (Sep - 20 -2017)
 */
public class ToDoList {
    private DoubleLinkedList <ToDoEntry> newNode = new DoubleLinkedList <ToDoEntry>();

    /**
     *Name: update
     *
     *Purpose:Update the object priority value based on the index(value in cmd file)
     *
     * @param - (index : int , priority : int)
     * 
     * @return - void
     */

    public void update(int index ,int priority)
    {
        newNode.update(index, priority); // call update from DoubleLinkedList class

    }
     
    /**
     *Name: remove
     *
     *Purpose:Remove the object priority value based on the index(value in cmd file)
     *
     * @param - (index : int)
     * 
     * @return - void
     */
    public void remove(int index)
    {
        newNode.remove(index); // call remove from DoubleLinkedList class
    }
    
     /**
     *Name: putInLinkesList 
     *
     *Purpose:Adds the object priority value based on the index(value in cmd file)
     *
     * @param - (index : int)
     * 
     * @return - void
     */

    public void putInLinkedList(ToDoEntry entry)
    {
        newNode.loadUpList(entry); // call remove from DoubleLinkedList class
    }

    public void print()
    {
        newNode.print();// call print from DoubleLinkedList class
    }
    public void writeToFile()throws IOException
    {
        newNode.writeToFile(); // call writeToFile from DoubleLinkedList class
    }
}
