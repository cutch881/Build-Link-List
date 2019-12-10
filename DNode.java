/**
 * Name: DNode
 * 
 * Fuction: To create a Node 
 *
 * @author (Mark Carvalho)
 * @version (Oct - 20 -2017)
 */
public class DNode <T extends StringAndNumber> // DNode only takes in values that implements the StringAndNumber Interface
{
    private T data; // item held by the DNode
    private DNode<T> next = null; // next node 
    private DNode<T> prev = null; // previous node 

     /**
     * Name: DNode
     * 
     * Purpose: Empty constructor setting data to null
     *
     * @param - N/A
     * 
     * @return - N/A
     */

    public DNode() { data = null; }
    
     /**
     * Name: DNode
     * 
     * Purpose: To set data, next, and prev to the values passed in
     *
     * @param - N/A
     * 
     * @return - N/A
     */
    public DNode(T data , DNode<T> next,DNode<T> prev ) { 
        this.data = data; 
        this.next = next;
        this.prev = prev;
    }
    
     /**
     * Name: getData
     * 
     * Purpose: To return data
     *
     * @param - N/A
     * 
     * @return - T
     */
    public T getData() { return data; }
     
     /**
     * Name: getData
     * 
     * Purpose: To set data to the value passed in
     *
     * @param - (value : T)
     * 
     * @return - void
     */
    public void setData(T value) { data = value; }
    
     /**
     * Name: getNext
     * 
     * Purpose: To return the next node 
     *
     * @param - N/A
     * 
     * @return - DNode<T>
     */
    public DNode<T> getNext() { return next; }
    
     /**
     * Name: setNext
     * 
     * Purpose: To set next to other
     *
     * @param - N/A
     * 
     * @return - void
     */
    public void setNext(DNode<T> other){ next = other; }
    
     /**
     * Name: getPrev
     * 
     * Purpose: To return the previous node 
     *
     * @param - N/A
     * 
     * @return - DNode<T>
     */
    public DNode<T> getPrev() { return prev; }
    
     /**
     * Name: setPrev
     * 
     * Purpose: To set prev to other
     *
     * @param - N/A
     * 
     * @return - void
     */
    public void setPrev(DNode<T> other){ prev = other; }
    
     /**
     * Name:  setPriorityNumber
     * 
     * Purpose: return the current priorityNum 
     *
     * @param - (N/A)
     * 
     * @return - int
     */
    public void setPriorityNumber(int num){getData().setPriorityNumber(num);}
     
    /**
     * Name:  setPriorityNumber
     * 
     * Purpose: sets the priorityNum to current value assigned when changed
     *
     * @param - (priority : int , discription : String )
     * 
     * @return - void
     */
    public int getPriorityNumber(){return getData().getPriorityNumber();}
    
    /**
     * Name:  getpriorityDiscription
     * 
     * Purpose: return the current priorityDiscription
     *
     * @param - (N/A)
     * 
     * @return - String
     */
    public String getPriorityDiscription(){return getData().getPriorityDiscription();}
    
    /**
     * Name:  compareTo
     * 
     * Purpose: compare data priority number to the  priority number of data passed in
     *
     * @param - (N/A)
     * 
     * @return - int
     */
    public int compareTo(T item) {
       
        if(item.getPriorityNumber() > getPriorityNumber())
        {   
            return  -1;
        }
        else if (item.getPriorityNumber() < getPriorityNumber())
        {
            return  1;
        }
        else 
        {
             return 0;
        }
   
    }

    
}