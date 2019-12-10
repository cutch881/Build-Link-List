
/**
 * Name: ToDoEntry
 * 
 * Fuction: To create ToDoEntry object 
 *
 * @author (Mark Carvalho)
 * @version (Sep - 20 -2017)
 */
    public class ToDoEntry implements StringAndNumber{

    private int priorityNum; // the priority number assigned in txt file
    private String priorityDiscription; // the discription assigned in  txt file
    /**
     * Name: ToDoEntry
     * 
     * Purpose: Default constructor, this sets priorityNum to 0 and priorityDiscription to ""
     *
     * @param - N/A
     * 
     * @return - N/A
     */

    public ToDoEntry()
    {
        priorityNum = 0; // set priorityNum to 0
        priorityDiscription = ""; // set priotityDiuscription to ""

    }

    /**
     * Name: ToDoEntry
     * 
     * Purpose: Constructor, this sets priorityNum to priority number got from txt file  and priorityDiscription to string got from txt file
     *
     * @param - (priority : int , discription : String )
     * 
     * @return - N/A
     */
    public ToDoEntry(int priority, String discription)
    {
        priorityNum = priority ;
        priorityDiscription = discription ;

    }

    /**
     * Name:  setPriorityNumber
     * 
     * Purpose: sets the priorityNum to current value assigned when changed
     *
     * @param - (priority : int , discription : String )
     * 
     * @return - void
     */

    public void setPriorityNumber(int num)
    {
        priorityNum = num;
    }

    /**
     * Name:  setPriorityNumber
     * 
     * Purpose: return the current priorityNum 
     *
     * @param - (N/A)
     * 
     * @return - int
     */
    public int getPriorityNumber()
    {
        return priorityNum;
    }

    /**
     * Name:  getpriorityDiscription
     * 
     * Purpose: return the current priorityDiscription
     *
     * @param - (N/A)
     * 
     * @return - String
     */
    public String getPriorityDiscription()
    {
        return priorityDiscription;
    }

    /**
     * Name:  toString
     * 
     * Purpose: return the object in string fromat
     *
     * @param - (N/A)
     * 
     * @return - String
     */
    public String toString()
    {
        return priorityNum + " " +  priorityDiscription + "\n";
    }
}
