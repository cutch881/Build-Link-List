/**
 * Name: DoubleLinkedList
 * 
 * Function: 
 * - To create DLL
 *
 * @author (Mark Carvalho)
 * @version (Oct - 20 -2017)
 */
import java.util.*;
import java.io.*;
public class DoubleLinkedList<T extends StringAndNumber>// DoubleLinkedList only takes in values that implements the StringAndNumber Interface
{
    private DNode<T> head; // head of the list
    private DNode<T> tail; // tail of the list
    private int size;      // size of the list

    /**
     * Name: DoubleLinkedList
     * 
     * Purpose: To set head and tail to null and size to 0
     * 
     * param: N/A
     * 
     * return: N/A
     */
    public  DoubleLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Name: isEmpty 
     * 
     * Purpose: Checks if head is null
     * 
     * param: N/A
     * 
     * return: boolean
     */
    public boolean isEmpty() {
        if(head == null)
        {
            return true;
        }
        else
        {
            return false;

        }
    }

    /**
     * Name: getSize 
     * 
     * Purpose: get size of the list
     * 
     * param: N/A
     * 
     * return: int
     */
    public int getSize()
    {   

        return size;   
    }

    /**
     * Name: setHead 
     * 
     * Purpose: to set node passed in as new head of the list
     * 
     * param: (head : DNode<T>)
     * 
     * return: void
     */
    public void setHead(DNode<T> head)
    {
        this.head = head;
    }

    /**
     * Name: getHead 
     * 
     * Purpose: to get the head
     * 
     * param: N/A
     * 
     * return: DNode<T>
     */
    public DNode<T> getHead()
    {

        return head;

    }

    /**
     * Name: setTail
     * 
     * Purpose: to set node passed in as new tail of the list
     * 
     * param: (head : DNode<T>)
     * 
     * return: void
     */

    public void setTail(DNode<T> tail)
    {

        this.tail = tail;

    }

    /**
     * Name: getTail 
     * 
     * Purpose: to get the tail
     * 
     * param: N/A
     * 
     * return: DNode<T>
     */
    public DNode<T> getTail()
    {

        return tail;

    }

    public DNode<T> getNode(int index)
    {
        int count = 1; // kees track of where we are at in the list
        DNode<T> mover = head; // mover is set to  head 
        while(count < index) // while count is less than index 
        {   
            count++; // increment count 
            mover= mover.getNext(); // mover is set to next node 
        }
        return mover;
    }

    /**
     * Name: loadUpList
     * 
     * Purpose: to build the DLL
     * 
     * param: (data : T)
     * 
     * return: void
     */
    public void loadUpList(T data)
    {

        if(isEmpty() == true) // if isEmpty method is true
        {   
            head = new DNode <T>(data,null,null); // set in first node in to the list
            tail = head; // for one node in the list head and tail will point to the same node
            size++; // increment size
        }

        else
        {
            boolean escapeIfAdded = false;
            DNode<T> mover = head; // mover is set to head
            DNode<T> nodesToAdd = new DNode<T>(data,null,null); // make new node
            while(escapeIfAdded == false) // while escapeIfMoved is still false run through again
            {
                if(nodesToAdd .compareTo(mover.getData()) == 1) // if compareTo method in DNode class returns 1
                {
                    if(mover.getPrev() == null) // if the previous value of the node is null
                    {
                        nodesToAdd.setNext(mover);// set the new nodes next to the mover
                        mover.setPrev(nodesToAdd); // set the mover prev to the new node
                        head = nodesToAdd; // head is now set to the new node
                        size++; // size increments
                        tail = nodesToAdd; //tail is set to new node 
                        escapeIfAdded = true;
                    }
                    else
                    {

                        nodesToAdd.setPrev(mover.getPrev()); // set new node prev to movers prev 
                        mover.getPrev().setNext(nodesToAdd); // set movers next of movers prev value to new node
                        nodesToAdd.setNext(mover); // set new node next to mover
                        mover.setPrev(nodesToAdd); // set mover prev to new node 
                        size++; // size increments
                        tail = nodesToAdd; //tail is to new node 
                        escapeIfAdded = true;

                    }

                }

                //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                else if(nodesToAdd .compareTo(mover.getData()) == -1) // if compareTo method in DNode class returns -1
                {
                    mover = mover.getNext(); // mover is set to next node 
                    if(mover == null) // if mover is null
                    {   
                        mover = head; // set mover to head 
                        while(mover.getNext()!= null) // while movers next is not null
                        {    mover = mover.getNext(); // mover is set to get next
                        }
                        nodesToAdd.setPrev(mover);// new node prev is set to mover
                        mover.setNext(nodesToAdd); // movers next is to new node 
                        tail = nodesToAdd; // tail is set to new node
                        size++;// size increments;
                        escapeIfAdded = true;     
                    }

                }

                //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                else if(nodesToAdd .compareTo(mover.getData()) == 0) //if compareTo method in DNode class returns -1
                {

                    if(mover.getNext() == null) // if movers next is == null
                    {   
                        mover = head; // mover is set to head 
                        while(mover.getNext()!= null) // while movers next is not null
                        {    
                            mover = mover.getNext(); // mover is set to next node 
                        }
                        nodesToAdd.setPrev(mover);// set new node prev to mover
                        mover.setNext(nodesToAdd); // set mover next to new node
                        nodesToAdd.setNext(null); // setr new node next to null
                        tail = nodesToAdd; // set tail to new node
                        size++;// size increments 
                        escapeIfAdded = true;

                    }
                    else if (mover.getNext() != null) // while movers next is not null
                    {
                        mover = mover.getNext(); // mover is set to next node 
                    }
                }
            }
        }

    }

    /**
     * Name: remove
     * 
     * Purpose: remove item from list
     * 
     * param: (index : int)
     * 
     * return: void
     */
    public void remove(int index)
    {   if(indexCheck(index) == true) // if index is valid
        {
            
            DNode <T> item = getNode(index);
            item.getPrev().setNext(item.getNext()); // set next of movers prev node to movers next
            item.getNext().setPrev(item.getPrev()); // set prev of movers next to movers prev 
            item.setNext(null); // mover next is null
            item.setPrev(null); // mover prev is null
            item= null; //mover is elimated 
            size--; // size decrements

        }
        else
        {
            System.out.println("\nThe item index you entered to remove was not valid");
        }
    }

    /**
     * Name: update
     * 
     * Purpose: update crertian item in the list
     * 
     * param: (index : int , priority : int)
     * 
     * return: void
     */
    public void update(int index, int priority)
    {   
        if(indexCheck(index) == true)// if index is valid
        {
            DNode <T> item = getNode(index);
            item.setPriorityNumber(priority); // set movers priority number to priority number passed in
            item.getPrev().setNext(item.getNext()); // set next of movers prev node to movers next
            item.getNext().setPrev(item.getPrev()); // set prev of movers next to movers prev 
            item.setNext(null);
            item.setPrev(null);
            size--;
            loadUpList(item.getData()); // put the mover in the loadUpList
        }
        else
        {
            System.out.println(" \nThe item index you entered to update was not valid");
        }
    }

    /**
     * Name: print 
     * 
     * Purpose: print in proper format into termanal 
     * 
     * param: N/A
     * 
     * return: void
     */
    public void print() 
    {  int priorityNum = 3, //Priority Number (Starts at 3 and goes down to 1)
        order = 0;           //Object order Number

        for (int counter1 = 0; counter1 < 3 ; counter1 ++) // Goes through array list three times 
        { 
            headings(counter1);
            DNode<T> mover = head;
            for (int index = 0;  index< getSize(); index++) // Goes through each item in the array list
            {   
                if(mover!=null)
                {
                    if (mover.getPriorityNumber() == priorityNum ) //if the objects priority number is equal to priority Num print the discription with the order(int variable) 
                    {   order++; // order inceiments by 1
                        System.out.println((order) + ": " + "   -" +mover.getPriorityDiscription() + "\n");
                    }  
                    mover = mover.getNext();
                }
            }
            priorityNum--; //priorityNum decrements by one at the end of outer loop
        }

        //System.out.println(); // print new line 
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); // print dividing line

    }

    /**
     * Name: headings
     * 
     * Purpose: print the headings of items based on priority
     * 
     * param: (counter : int)
     * 
     * return: void
     */
    public void headings(int counter1)
    {

        if(counter1 == 0) //if it goes through one time print "\nHigh Priority" 
        {
            System.out.println("\nHigh Priority");
            System.out.println();
        }
        if(counter1 == 1) //if it goes through two times print "Medium Priority" 
        {
            System.out.println("Medium Priority");
            System.out.println();
        }
        if(counter1 == 2) // if it goes through three times print "Low Priority"  
        {
            System.out.println("Low Priority");
            System.out.println();
        }

    }

    /**
     * Name: WriteToFile 
     * 
     * Purpose: print in proper format into file
     * 
     * param: N/A
     * 
     * return: void
     */
    public void writeToFile()throws IOException
    {

        DNode<T> mover = head; // mover set to head 
        FileWriter fw = new FileWriter("out.txt",true);// file writer object
        PrintWriter outputFile = new PrintWriter(fw); // print writer object
        while(mover != null) //while mover is not null
        {   
            outputFile.println( mover.getPriorityNumber()+ " " + mover.getPriorityDiscription());
            mover= mover.getNext();
        }
        outputFile.close(); // printer writer close 
        fw.close( );   // file writer close 

    }

    /**
     * Name: indexCheck
     * 
     * Purpose: checkes if the index entered by user is valid
     * 
     * param: (index : int)
     * 
     * return: void
     */
    public boolean indexCheck(int index)
    {  boolean check = true;
        if(index > 0 &&  index <= size) // if index is greater than 0 or less than and equal to size 
        {
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }
}
