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

import java.util.List;
import java.util.Scanner;
import java.io.*;

/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

	static Scanner kb; // scanner connected to keyboard input, or input file
	private static String inputFile; // input file, used instead of keyboard
										// input if specified
	static ByteArrayOutputStream testOutputString; // if test specified, holds
													// all console output
	private static String myPackage; // package of Critter file. Critter cannot
										// be in default pkg.
	private static boolean DEBUG = false; // Use it or not, as you wish!
	static PrintStream old = System.out; // if you want to restore output to
											// console

	// Gets the package name. The usage assumes that Critter and its subclasses
	// are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            args can be empty. If not empty, provide two parameters -- the
	 *            first is a file name, and the second is test (for test output,
	 *            where all output to be directed to a String), or nothing.
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
				if (args[1].equals("test")) { // if the word "test" is the
												// second argument to java
					// Create a stream to hold the output
					testOutputString = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(testOutputString);
					// Save the old System.out.
					old = System.out;
					// Tell Java to use the special stream; all console output
					// will be redirected here from now
					System.setOut(ps);
				}
			}
		} else { // if no arguments to main
			kb = new Scanner(System.in); // use keyboard and console
		}

		/* Do not alter the code above for your submission. */
		/* Write your code below. */
		// some critters to world

		while (true) {
			System.out.print("critters>");
			String command = kb.nextLine();
			String trimedCmd = command.trim();
			String[] cmdArr;
			cmdArr = trimedCmd.split("[ ]+");
			/////////
			///////// QUIT
			/////////
			if (cmdArr[0].equals("quit")) {
				if (cmdArr.length > 1) {
					System.out.println("error processing: " + trimedCmd);
				} else {
					kb.close();
					return;
				}
			}
			/////////
			///////// SHOW
			/////////
			else if (cmdArr[0].equals("show")) {
				if (cmdArr.length > 1) {
					System.out.println("error processing: " + trimedCmd);
				} else {
					Critter.displayWorld();
					System.out.println("");
				}
			}
			/////////
			///////// STEP
			/////////
			else if (cmdArr[0].equals("step")) {
				if (cmdArr.length > 2) {
					System.out.println("error processing: " + trimedCmd);
				} else if (cmdArr.length == 1) {
					Critter.worldTimeStep();
				} else {
					try {
						int stepNum = Integer.parseInt(cmdArr[1]);
						while (stepNum > 0) {
							Critter.worldTimeStep();
							stepNum--;
						}
					} catch (Exception e) {
						System.out.println("error processing: " + trimedCmd);
					}
				}
			}
			/////////
			///////// SEED
			/////////
			else if (cmdArr[0].equals("seed")) {
				if (cmdArr.length > 2 || cmdArr.length < 2) {
					System.out.println("error processing: " + trimedCmd);
				} else {
					int seedNum;
					try {
						seedNum = Integer.parseInt(cmdArr[1]);
						Critter.setSeed(seedNum);
					} catch (Exception e) {
						System.out.println("error processing: " + trimedCmd);
					}
				}
			}
			/////////
			///////// MAKE
			/////////
			else if (cmdArr[0].equals("make")) {
				if (cmdArr.length > 3 || cmdArr.length < 2) {
					System.out.println("error processing: " + trimedCmd);
				} else if (cmdArr.length == 2) {
					try {
						Critter.makeCritter(myPackage + "." + cmdArr[1]);
					} catch (InvalidCritterException e) {
						System.out.println("error processing: " + trimedCmd);
					}
				} else {
					int makeNum;
					// String className = cmdArr[1];
					try {
						makeNum = Integer.parseInt(cmdArr[2]);
						for (int i = 0; i < makeNum; i++) {
							Critter.makeCritter(myPackage + "." + cmdArr[1]);
						}
					} catch (InvalidCritterException e) {
						System.out.println("error processing: " + trimedCmd);
						// break;
					} catch (Exception e) {
						System.out.println("error processing: " + trimedCmd);
					}
				}

			}
			/////////
			///////// STATS
			/////////
			else if (cmdArr[0].equals("stats")) {
				if (cmdArr.length > 2 || cmdArr.length < 2) {
					System.out.println("error processing: " + trimedCmd);
				} else {
					// finish writing stats
					List<Critter> result = new java.util.ArrayList<Critter>();
					try {
						Class<?> myClass = Class.forName(myPackage + "." + cmdArr[1]);
						Critter myCritter = (Critter) myClass.newInstance();
						result = Critter.getInstances(myPackage + "." + cmdArr[1]);
						Critter.runStats(result);
					} catch (InvalidCritterException e) {
						System.out.println("error processing: " + trimedCmd);
					} catch (Exception e) {
						System.out.println("error processing: " + trimedCmd);
					}
				}

			} else {
				System.out.println("invalid command: " + trimedCmd);
			}

			// System.out.println("GLHF");

			/* Write your code above */
			System.out.flush();

		}
	}
}
