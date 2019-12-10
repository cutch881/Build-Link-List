import java.util.*;
import java.io.*;
/**
 * Name: ReadAndWriteToFile
 * 
 * Function: 
 * -To read txt files and write to txt files.
 * -To interact with the ToDoEntry class and ToDoList class
 *
 * @author (Mark Carvalho)
 * @version (Sep - 20 -2017)
 */
public class ReadAndWriteToFile
{

    /**
     * Name: readFromFile 
     * 
     * Purpose: Read from todo.txt and cmd.txt
     *
     * @param :(listFileName : String, cmdFileName : String)
     * 
     * @return :  void
     */
    public void readFromFile(String listFileName, String cmdFileName)throws IOException
    {

        String priorityVal ="", // String value for priority number got from txt file
        discription = "",       // discription got from txt file 
        operations = " ",       // commands obtained from cmd.txt
        entireLine  = "",
        priorityChar = " ";     // letter identifying the priority number

        int priority = 0, // priorityVal converted to int
        lineNum = 0,      // current line in todo.txt file
        itemToRemove = 0, // identification number of item to remove
        length = 0,
        itemToUpdate = 0; // identification number of item to update

        ToDoList list = new ToDoList();// maker to do list object

        try{
            //-------------Read from todo.txt---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------       
            File listFile = new File(listFileName); // file object
            Scanner in = new Scanner(listFile);     // scanner object

            while (in.hasNextLine()) {
                try{

                    //checkIfAtLastItem = false;
                    entireLine = in.nextLine(); // get the entile line from the text file
                    length =  entireLine.length(); //get length from text file

                    if(length > 1) // if the length is > 1
                    {
                        priorityVal = entireLine.substring(0,entireLine.indexOf(' ')); // get priority value before the first space
                        discription = entireLine.substring(entireLine.indexOf(' ')+1);// get discription value after the first space    
                    }
                    else
                    {    priorityVal = entireLine.substring(0); 
                        discription  ="";
                    }
                    lineNum++; // line num increments by 1

                    if(entireLine.isEmpty()) // if entire line is empty
                    {

                        System.out.println("Error - Missing Entire Priority: "+ '"' + '"'+ " on line number " + lineNum);

                    }

                    else if (discription.equals("")) // if the discription is empty
                    {

                        System.out.println("Error - Missing Description: " + '"' + priorityVal  +'"'+ " on line number " +lineNum);
                    }
                    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                    else
                    {
                        priority = Integer.parseInt(priorityVal); //convert priorityVal to priority

                        if (priority > 3 || priority < 0) // if priority is higher than 3 or lower than 0
                        {
                            priority = 1; // set priority to one
                        }

                        ToDoEntry entry = new ToDoEntry(priority, discription); // make ToDoEntry object by passing in priority, and discription into constructor
                        list.putInLinkedList(entry);

                    }
                    // 
                    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                }

                catch(NumberFormatException e) // if there is a NumberFormatException (when priorityVal can not be converted to an int because the first part in entireLine before the first space is not a int value)
                {

                    System.out.println("Error - Missing Priority Number: " + '"'+entireLine+ '"' + " on line number " + lineNum);

                }
            }

            //-----------------Read from cmd.txt----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------       
            File cmdFile = new File(cmdFileName); // file object
            Scanner in2 = new Scanner(cmdFile);   // scanner object

            while(in2.hasNextLine()) // while file has next line
            {
                operations = in2.next().toLowerCase(); // get the letter command and turn it to lower case 
                switch(operations)
                {
                    case "a": // if oprations = a 
                    priorityChar = in2.next().toLowerCase();// get priorityChar and set to lower case
                    discription = in2.nextLine().toLowerCase(); // get discription and set to lower case

                    if(priorityChar.equals("h") ) // if priorityChar = h
                    {
                        priority = 3; // set priority to 3
                        ToDoEntry entry = new ToDoEntry(priority, discription); // make ToDoEntry Object 
                        list.putInLinkedList(entry); //call add from ToDoLisrt to add.
                    }

                    else if(priorityChar.equals("m") ) // if priorityChar = m
                    {
                        priority = 2;// set priority to 2
                        ToDoEntry entry = new ToDoEntry(priority, discription);// make ToDoEntry Object 
                        list.putInLinkedList(entry);//call add from ToDoLisrt to add.
                    }

                    else if (priorityChar.equals("l"))// if priorityChar = l
                    {
                        priority = 1;// set priority to 1
                        ToDoEntry entry = new ToDoEntry(priority, discription);// make ToDoEntry Object
                        list.putInLinkedList(entry);//call add from ToDoLisrt to add.
                    }
                    break;

                    case "u": //if operations = u
                    itemToUpdate= in2.nextInt(); // get value for itemToUpdate 
                    priorityChar = in2.next().toLowerCase(); //get priorityChar and set to lower case

                    if(priorityChar.equals("h") ) // if priorityChar = h
                    {
                        priority = 3;// set priority to 3
                        list.update(itemToUpdate,priority); //call update method from ToDoList class
                    }

                    else if(priorityChar.equals("m") )// if priorityChar = m
                    {
                        priority = 2;// set priority to 2
                        list.update(itemToUpdate,priority);//call update method from ToDoList class
                    }

                    else if (priorityChar.equals("l")) // if priorityChar = l
                    {
                        priority = 1;// set priority to 1
                        list.update(itemToUpdate,priority);//call update method from ToDoList class
                    }
                    break;

                    case "r": // if operations = r
                    itemToRemove= in2.nextInt(); // get value for itemsToRemove
                    list.remove(itemToRemove); //call remove method from ToDoList class
                    break;

                    case "d": // if operations = d

                    System.out.println("\n");
                    list.print();//call print method from ToDoList class
                    break;
                }

            }

            clearOutPutFile(); // clear out put File
            list.writeToFile(); // call exit method in ToDoList class

        }
        catch(FileNotFoundException e)
        {
            System.out.println("The files are not Found");

        }

    }

    /**
     * Name: clearOutPutFile
     * 
     * Purpose: Clear previous text in txt file
     *
     * @param :(N/A)
     * 
     * @return :  void
     */

    public void clearOutPutFile()throws IOException
    {
        FileWriter fw = new FileWriter("out.txt"); // file writer object
        PrintWriter outputFile = new PrintWriter(fw); // print writer object
        outputFile.print(""); // replace all text in txt file with ""
        outputFile.close();   // printer writer close 
        fw.close( );          // file writer close 

    }

}
