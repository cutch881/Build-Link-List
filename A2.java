import java.io.*;
import java.util.*;
/**
 * Name: Main 
 * 
 *Puprose: Pass in file names into ReadAndWriteToFile clkass
 *
 * @author (Mark Carvalho)
 * 
 * @version (Sep - 20 -2017)
 */
public class A2
{
    public static void main(String[] args) throws IOException {

        
        String listFile = "",  // txt list file name 
                cmdFile = " "; // cmds file name 
        
        System.out.println("Welcome to the priority list program");
        listFile = "todo3.txt"; // listFile set to todo.txt
        System.out.println("File with list is " + listFile);
        cmdFile = "cmd3.txt";  // cmdFile set to cmd.txt
        System.out.println("File with commands is " + cmdFile +"\n");
               
        
        ReadAndWriteToFile process = new ReadAndWriteToFile();// ReadAndWriteToFile object created
        process.readFromFile(listFile, cmdFile); // pass in file names to readFromFile() in ReadAndWriteToFile class
    }
 }
