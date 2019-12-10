
/**
 *This class allows the ToDoEntry class to implement these
 *methods via interface. Thus making it easier for classes using
 *generics to have acess to these methods within the interface class
 *
 * @author (Mark Carvalho)
 * @version (Oct 21 2017)
 */
public interface StringAndNumber
{
 /**
     * Name:  setPriorityNumber
     * 
     * Purpose: return the current priorityNum 
     *
     * @param - (N/A)
     * 
     * @return - int
     */
    void setPriorityNumber(int num);
    
     /**
     * Name:  setPriorityNumber
     * 
     * Purpose: sets the priorityNum to current value assigned when changed
     *
     * @param - (priority : int , discription : String )
     * 
     * @return - void
     */
    int getPriorityNumber();
    
     /**
     * Name:  getpriorityDiscription
     * 
     * Purpose: return the current priorityDiscription
     *
     * @param - (N/A)
     * 
     * @return - String
     */
    String getPriorityDiscription();
    
}
