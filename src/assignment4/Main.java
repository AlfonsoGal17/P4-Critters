/* CRITTERS 
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Alfonso Galindo
 * ag49477
 * 16450
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2016
 */


package assignment4; // cannot be in default package
import java.util.Scanner;
import java.io.*;


/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     */
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

        /* Do not alter the code above for your submission. */
        /* Write your code below. */
        // some critters to world
        for(int i =0; i < 10; i++){
            try{
            	Critter.makeCritter(myPackage + "." + "Algae");
            }
            catch(Exception e){
            	e.printStackTrace();
            	System.out.println("no class named Algae");
            }
            }
        for(int i =0; i < 50; i++){
            try{
            	Critter.makeCritter(myPackage + "." + "Craig");
            }
            catch(Exception e){
            	e.printStackTrace();
            	System.out.println("no class named Algae");
            }
            }
        while(true){
        System.out.print("critters>");
        String command = kb.nextLine();
        String trimedCmd = command.trim();
        String[] cmdArr;
        cmdArr = trimedCmd.split("[ ]+");
        
        
        if(cmdArr[0].equals("quit")){
        	return;
        }
        else if(cmdArr[0].equals("show")){
        	Critter.displayWorld();
        	System.out.println("");
        }
        else if(cmdArr[0].equals("step")){
        	if(cmdArr.length > 2){
        		System.out.println("error processing: "+ trimedCmd);
        	}
        	if(cmdArr.length ==1){
        		Critter.worldTimeStep();
        	}
        	else{
        		try{
        		int stepNum = Integer.parseInt(cmdArr[1]);
        		while(stepNum > 0){
        			Critter.worldTimeStep();
        			stepNum--;
        		}}
        		catch(Exception e){
        			System.out.println("error processing: "+ trimedCmd);
        		}
        	}
        }
        else{
        	System.out.println("invalid command: "+ trimedCmd);
        }
        
       
        }
        //System.out.println("GLHF");
       
        /* Write your code above */
        //System.out.flush();

    }
}
